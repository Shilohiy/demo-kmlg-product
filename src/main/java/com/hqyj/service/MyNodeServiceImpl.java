package com.hqyj.service;

import com.hqyj.dao.MyNodeMapper;
import com.hqyj.pojo.MyNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MyNodeServiceImpl implements MyNodeService {
    @Autowired(required = false)
    MyNodeMapper mapper;
    @Override
    public HashMap<String, Object> selectPower(String userName) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<MyNode> list = mapper.selectPower(userName);
        List<MyNode> list1 = new ArrayList<>();
        if(list!=null){
            //构建权限菜单的数据结构
            for(MyNode n:list){
                if(n.getParentId()==0){
                    MyNode nn = new MyNode();
                    nn.setUrl(n.getUrl());
                    nn.setIndex(n.getIndex());
                    nn.setName(n.getName());
                    //创建一个集合
                    List<MyNode> listChilder = new ArrayList<>();
                    //查询子菜单
                    for(MyNode m:list){
                        if(m.getParentId()==n.getNodeId()){
                            listChilder.add(m);
                        }
                    }
                    nn.setChildren(listChilder);
                    list1.add(nn);
                }
            }
        }
        map.put("info",list1);
        return map;
    }
}
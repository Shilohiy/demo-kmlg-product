package com.hqyj.pojo;

import lombok.Data;

import java.util.List;

@Data
public class MyNode {
    //权限索引
    private String index;
    //权限名称
    private String name;
    //子菜单集合
    private List<MyNode> children;
    //权限路由地址
    private String url;
    //父节点
    private Integer parentId;
    //节点
    private Integer nodeId;
}
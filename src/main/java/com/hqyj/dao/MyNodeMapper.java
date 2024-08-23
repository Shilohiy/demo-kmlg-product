package com.hqyj.dao;

import com.hqyj.pojo.MyNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyNodeMapper {

    List<MyNode> selectPower(String userName);
}
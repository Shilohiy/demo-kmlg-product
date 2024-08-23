package com.hqyj.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

public class MyNodeController {

    //查询权限
    @GetMapping("/selectPower")
    public HashMap<String,Object> selectPower(String userName){

        MyNodeController myNodeService = null;
        return myNodeService.selectPower(userName);
    }
}

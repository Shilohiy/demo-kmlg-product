package com.hqyj.controller;


import com.hqyj.pojo.OrderInfo;
import com.hqyj.pojo.ResultVo;
import com.hqyj.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rock
 * @since 2024-08-22
 */
@RestController
@RequestMapping("/order-info")
public class OrderInfoController {

    @Autowired
    IOrderInfoService service;

    public ResultVo addOrderInfo(OrderInfo orderInfo) {
        return service.addOrder(orderInfo);
    }

}


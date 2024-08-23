package com.hqyj.controller;


import com.hqyj.pojo.OrderInfo;
import com.hqyj.pojo.ResultVo;
import com.hqyj.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@RestController
@RequestMapping("/order-info")
public class OrderInfoController {

    @Autowired
    IOrderInfoService service;
    //添加订单
    @PostMapping("/add")
    public ResultVo addOrder(@RequestBody OrderInfo orderInfo){
        return service.addOrder(orderInfo);
    }
    //获取支付宝支付的二维码地址
    @GetMapping("/getCode")
    public void getCode(String orderId, Double money, String title, String desc, HttpServletResponse response){
        PrintWriter pw = null;
        try{
             pw = response.getWriter();
            //获取地址
            String url = service.createCode(orderId,money,title,desc);
            //生成流
            pw.print(url);
            pw.flush();
        }catch (Exception e){
           e.printStackTrace();
        }finally {
            pw.close();
        }

    }


}


package com.hqyj.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hqyj.pojo.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hqyj.pojo.ResultVo;

public interface IOrderInfoService extends IService<OrderInfo> {


    //新增订单
    ResultVo addOrder(OrderInfo order);

    /**
     * 生成支付宝二维码支付链接
     * @param orderId 订单编号
     * @param money   付款金额
     * @param title   订单标题
     * @param desc    订单描述
     * @return
     */
    String createCode(String orderId,Double money,String title,String desc) throws JsonProcessingException;

}

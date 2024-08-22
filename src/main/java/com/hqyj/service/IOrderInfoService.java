package com.hqyj.service;

import com.hqyj.pojo.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hqyj.pojo.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rock
 * @since 2024-08-22
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    //新增订单
    ResultVo addOrder(OrderInfo order);

}

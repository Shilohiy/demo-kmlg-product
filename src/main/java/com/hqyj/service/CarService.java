package com.hqyj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hqyj.pojo.Car;
import com.hqyj.pojo.OrderInfo;
import com.hqyj.pojo.ResultVo;

public interface CarService extends IService<Car> {

    //添加购物车
    ResultVo addCar(Car car);
    //查询用户购物车,参数是用户Id(根据用户Id查询用户的购物车)
    ResultVo queryCar(Integer userId);
    //删除购物车的一个购物车
    ResultVo delCar(Integer id);
}

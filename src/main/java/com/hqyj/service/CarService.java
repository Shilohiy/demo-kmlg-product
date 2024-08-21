package com.hqyj.service;

import com.hqyj.pojo.Car;
import com.hqyj.pojo.ResultVo;

public interface CarService {
    // 添加购物车
    ResultVo addCar(Car car);
    // 查询用户的购物车
    ResultVo queryCar(Integer userid);
    // 删除购物车的一个商品
    ResultVo delCar(Integer id);
}

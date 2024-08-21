package com.hqyj.controller;

import com.hqyj.pojo.Car;
import com.hqyj.pojo.ResultVo;
import com.hqyj.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;
    // 添加购物车
    @PostMapping("/addCar")
    public ResultVo addCar(@RequestBody  Car car) {
        return carService.addCar(car);
    }
    // 查询购物车
    @GetMapping("/query")
    public ResultVo queryCar(Integer userId) {
        return carService.queryCar(userId);
    }
    // 删除购物车
    @GetMapping("/del")
    public ResultVo delCar(Integer id) {
        return carService.delCar(id);
    }
}

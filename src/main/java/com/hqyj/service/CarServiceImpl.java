package com.hqyj.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hqyj.dao.CarDao;
import com.hqyj.pojo.Car;
import com.hqyj.pojo.ResultVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl extends ServiceImpl<CarDao, Car> implements CarService{
    @Resource
    CarDao carDao;
    //添加购物车
    @Override
    public ResultVo addCar(Car car) {
        int num = carDao.insert(car);
        if (num>0){
            return ResultVo.success();
        }
        return ResultVo.error();
    }

    //查询购物车
    @Override
    public ResultVo queryCar(Integer userId) {
        QueryWrapper<Car> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<Car> list = carDao.selectList(queryWrapper);
        if (list.size()>0){
            return ResultVo.success(list);
        }
        return ResultVo.error("购物车没有数据");
    }
    //删除购物车
    @Override
    public ResultVo delCar(Integer id) {
        int num = carDao.deleteById(id);
        if (num>0){
            return ResultVo.success();
        }
        return ResultVo.error();
    }
}

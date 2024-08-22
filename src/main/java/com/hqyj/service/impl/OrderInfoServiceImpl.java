package com.hqyj.service.impl;

import com.hqyj.pojo.Car;
import com.hqyj.pojo.OrderInfo;
import com.hqyj.dao.OrderInfoMapper;
import com.hqyj.pojo.ResultVo;
import com.hqyj.service.CarService;
import com.hqyj.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rock
 * @since 2024-08-22
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Resource
    OrderInfoMapper orderInfoMapper;

    @Autowired
    CarService carService;

    @Transactional
    @Override
    public ResultVo addOrder(OrderInfo order) {

        int num = orderInfoMapper.insert(order);
        if (num >0){
            //批量更改购物车的订单id,创建多个购物车对象
            List<Car> list = new ArrayList<>();
            for (Integer id : order.getList()){
                Car c = new Car();
                c.setId(id);
                list.add(c);
            }
            //批量修改
            boolean is = carService.updateBatchById(list);
            if (is){
                return ResultVo.success("新增订单成功");
            }

        }
        return ResultVo.error("新增订单失败");
    }
}

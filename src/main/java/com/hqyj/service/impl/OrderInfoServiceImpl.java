package com.hqyj.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    AlipayClient alipayClient;

    @Transactional
    @Override
    public ResultVo addOrder(OrderInfo order) {
        int num = orderInfoMapper.insert(order);
        if(num > 0 ){
            //批量更改购物车的订单id
            List<Car> list = new ArrayList<>();
            for(Integer id : order.getList()){
                Car c = new Car();
                c.setId(id);
                //修改订单id
                c.setOrderId(order.getOrderId());
                list.add(c);
            }
            //批量修改
            boolean is = carService.updateBatchById(list);
            if(is){
               return ResultVo.success("新增订单成功");
            }
        }
        return ResultVo.error("新增订单失败");
    }

    @Override
    public String createCode(String orderId, Double money, String title, String desc) {
        Map<String, Object> map = new HashMap<>();
        map.put("out_trade_no", orderId);
        map.put("total_amount",money);
        map.put("subject", title);
        map.put("body", desc);

        try {
            //把请求参数转换成 json格式的字符串
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(map);
            //创建支付请求对象
            AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
            request.setBizContent(jsonString);
            try {
                AlipayTradePrecreateResponse response =alipayClient.execute(request);
                if(response.isSuccess()){
                    //返回支付的二维码地址
                    return response.getQrCode();
                }
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //返回错误的二维码地址
        return "http://www.baidu.com";
    }
}

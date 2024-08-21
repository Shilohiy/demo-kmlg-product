package com.hqyj.controller;

import com.hqyj.dto.GoodsInfoDto;
import com.hqyj.pojo.ResultVo;
import com.hqyj.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsInfoController {

    // 注入goodsInfoController实现类对象
    @Autowired
    GoodsInfoService service;
    // 根据商品类型查询商品信息
    @GetMapping("/query")
    public ResultVo queryGoodsByType(GoodsInfoDto dto){
        return service.queryGoodsInfoByType(dto);
    }

    @GetMapping("/detail")
    // 根据商品id查询商品详情
    public ResultVo query(Integer goodsId){

        return service.queryGoodsInfoDetailByGoodsId(goodsId);
    }
}

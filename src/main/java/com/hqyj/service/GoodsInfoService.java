package com.hqyj.service;

import com.hqyj.dto.GoodsInfoDto;
import com.hqyj.pojo.ResultVo;

public interface GoodsInfoService {

    //商品分类查询
    ResultVo queryGoodsInfoByType(GoodsInfoDto goodsInfoDto);

    // 查询商品详情
    ResultVo queryGoodsInfoDetailByGoodsId(Integer goodsId);
}

package com.hqyj.dto;

import com.hqyj.pojo.MyPage;
import lombok.Data;

//封装查询条件
@Data
public class GoodsInfoDto extends MyPage {
    // 商品类型
    private Integer proType;
    // 品牌
    private Integer brandId;
    // 最低价格
    private Double startPrice;
    // 最高价格
    private Double endPrice;
    // 价格排序高到低
    private Double priceOrderD;
    // 价格排序低到高
    private Double priceOrderA;



}

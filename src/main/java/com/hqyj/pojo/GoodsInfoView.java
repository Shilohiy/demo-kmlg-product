package com.hqyj.pojo;

import lombok.Data;


@Data
public class GoodsInfoView {

    private Integer goodsId;
    private Double price;
    private String brandName;
    private Integer sellerId;
    private String title;
    private String src;
    private Integer proType;
    private Integer stockNum;

}

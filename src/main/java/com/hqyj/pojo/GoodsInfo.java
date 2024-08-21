package com.hqyj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Value;

@TableName("goods_info")
@Data
public class GoodsInfo {

     @TableId(value = "goods_id",type = IdType.AUTO)
    private Integer goodsId;
    private Double price;
    private Integer brandId;
    private Integer sellerId;
    private String title;
    private String src;
    private Integer proType;
    private Integer stockNum;

}

package com.hqyj.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("car")
public class Car {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer goodsId;
    private Integer userId;
    private String goodsName;
    private Integer num;
    private Double price;
    private String src;
    private String orderId;

    @TableLogic
    private Integer deleteTag;
}

package com.hqyj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("product_index")
@Data
public class ProductIndex {

    @TableId(value = "pro_id", type = IdType.AUTO)
    private Integer proId;
    private String imgUrl;
    private String imgDesc;
    private Integer imgType;
    private Integer proType;
}

package com.hqyj.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("brand")
@Data
public class Brand {
    private Integer brandId;
    private String brandName;
    private Integer proType;
}


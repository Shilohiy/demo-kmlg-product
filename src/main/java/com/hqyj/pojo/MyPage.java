package com.hqyj.pojo;

import lombok.Data;

@Data
public class MyPage {
    //页码
    private Integer page;
    //每页显示条数
    private Integer row;
}

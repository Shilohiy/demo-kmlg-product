package com.hqyj.controller;

import com.hqyj.dto.BrandDto;
import com.hqyj.pojo.ResultVo;
import com.hqyj.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    BrandService service;

    @GetMapping("/query")
    public ResultVo queryBrandById(BrandDto dto){
        return service.queryBrandById(dto);
    }
}

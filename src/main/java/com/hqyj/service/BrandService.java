package com.hqyj.service;

import com.hqyj.dto.BrandDto;
import com.hqyj.pojo.ResultVo;

public interface BrandService {
    ResultVo queryBrandById(BrandDto brandDto);
}

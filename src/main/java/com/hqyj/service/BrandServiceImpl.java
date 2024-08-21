package com.hqyj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hqyj.dao.BrandDao;
import com.hqyj.dto.BrandDto;
import com.hqyj.pojo.Brand;
import com.hqyj.pojo.ResultVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService{
    @Resource
    BrandDao brandDao;

    @Override
    public ResultVo queryBrandById(BrandDto brandDto) {
        //创建条件构造器
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();

        List<Brand> brandList = brandDao.selectList(queryWrapper);
        if (brandList != null && !brandList.isEmpty()){
            Map<String,Object> map = new HashMap<>();
            map.put("list",brandList);
            return ResultVo.success(map);
        }
        return ResultVo.error("没有查询到相关信息");
    }

}
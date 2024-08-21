package com.hqyj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hqyj.dao.GoodsInfoDao;
import com.hqyj.dto.GoodsInfoDto;
import com.hqyj.pojo.GoodsInfo;
import com.hqyj.pojo.GoodsInfoView;
import com.hqyj.pojo.ResultVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {


    @Resource
    GoodsInfoDao goodsInfoDao;

    @Override
    public ResultVo queryGoodsInfoByType(GoodsInfoDto goodsInfoDto) {
         //创建条件构造器
        QueryWrapper<GoodsInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pro_type",goodsInfoDto.getProType());
        //判断是否需要添加品牌作为条件查询
        boolean isBrand = goodsInfoDto.getBrandId()!=0&&goodsInfoDto.getBrandId()!=null;
        //品牌查询
        queryWrapper.eq(isBrand,"brand_id",goodsInfoDto.getBrandId());
        //价格区间查询
        boolean isPrice = goodsInfoDto.getStartPrice()!=0&&goodsInfoDto.getStartPrice()!=null;
        queryWrapper.between(isPrice,"price",goodsInfoDto.getStartPrice(),goodsInfoDto.getEndPrice());
        //价格区间高低查询
        boolean PriceOrderD = goodsInfoDto.getPriceOrderD()!=0&&goodsInfoDto.getPriceOrderD()!=null;
        boolean PriceOrderA = goodsInfoDto.getPriceOrderA()!=0&&goodsInfoDto.getPriceOrderA()!=null;
        // 价格从高到低
        queryWrapper.orderByDesc(PriceOrderD,"price");
        // 价格从低到高
        queryWrapper.orderByAsc(PriceOrderA,"price");



        //创建分页对象
        Page<GoodsInfo> page = new Page<>(goodsInfoDto.getPage(),goodsInfoDto.getRow());
        //查询分页
        Page<GoodsInfo> infoPage = goodsInfoDao.selectPage(page,queryWrapper);
        if(infoPage.getRecords().size()>0){
            Map<String,Object> map = new HashMap<>();
            //当前页集合
            map.put("list",infoPage.getRecords());
            //总页数
            map.put("totalPage",infoPage.getPages());
            //总条数
            map.put("total",infoPage.getTotal());
            //返回结果集
            return ResultVo.success(map);
        }
        return ResultVo.error("没有查询到数据");
    }

    @Override
    public ResultVo queryGoodsInfoDetailByGoodsId(Integer goodsId) {
        // 查询商品详情
        GoodsInfoView view = goodsInfoDao.query(goodsId);
        if(view != null){
            return ResultVo.success(view);
        }
        return ResultVo.error();
    }
}

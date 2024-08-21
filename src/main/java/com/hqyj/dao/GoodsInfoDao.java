package com.hqyj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hqyj.pojo.GoodsInfo;
import com.hqyj.pojo.GoodsInfoView;
import org.apache.ibatis.annotations.Mapper;

@Mapper//1 表示这是一个数据层 2  创建这个接口的实现类的对象
public interface GoodsInfoDao extends BaseMapper<GoodsInfo> {

    // 查询商品详情
    GoodsInfoView query(Integer goodsId);

}

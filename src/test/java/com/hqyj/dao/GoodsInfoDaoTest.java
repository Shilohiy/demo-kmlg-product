package com.hqyj.dao;

import com.hqyj.MyApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)//spring测试的运行器注解
@SpringBootTest(classes = MyApp.class) //springboot测试类注解
public class GoodsInfoDaoTest {

      //获取goodsInfoDao的实现类对象
      @Resource//用于获取数据层的接口实现类对象
      GoodsInfoDao goodsInfoDao;

     @Test
     public void query(){
          goodsInfoDao.selectList(null);
     }

}

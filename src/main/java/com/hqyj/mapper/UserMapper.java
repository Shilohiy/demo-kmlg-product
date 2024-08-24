package com.hqyj.mapper;

import com.hqyj.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    // MyBatis-Plus 会自动生成CRUD操作，无需写任何代码
    @Select("SELECT COUNT(*) FROM user WHERE user_name = #{userName}")
    int countByUserName(String userName);
}

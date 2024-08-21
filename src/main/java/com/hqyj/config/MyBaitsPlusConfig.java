package com.hqyj.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBaitsPlusConfig {

    @Bean
    public PaginationInterceptor getBean() {
        return new PaginationInterceptor();
    }
}

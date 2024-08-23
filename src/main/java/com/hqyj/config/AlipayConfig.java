package com.hqyj.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfig {

    @Autowired
    private PayConfig payConfig;

    //获得初始化的AlipayClient
    @Bean
    public AlipayClient alipayClient () {
        return   new DefaultAlipayClient(
                payConfig.getGatewayUrl(),
                payConfig.getAppId(),
                payConfig.getPrivateKey(),
                payConfig.getFormat(),
                payConfig.getCharset(),
                payConfig.getPublicKey(),
                payConfig.getSignType());
    }

}

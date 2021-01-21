package com.py.agw.config;

import com.alibaba.dubbo.config.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description：dubbo消费者配置
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/13
 */
@Configuration
public class DubboConsumerConfig extends DubboBaseConfig{

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setMonitor(monitorConfig());
        return consumerConfig;
    }
}

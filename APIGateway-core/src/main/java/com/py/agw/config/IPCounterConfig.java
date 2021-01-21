package com.py.agw.config;

import com.py.agw.chains.support.IPCounter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description：ip统计计数配置
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/13
 */
@Configuration
public class IPCounterConfig {

    @Value("${ipCounter.timeRule}")
    private int timeRule;

    @Value("${ipCounter.countRule}")
    private int countRule;

    @Bean
    public IPCounter ipCounter() {
        // todo 从动态配置中心获取
        return new IPCounter(countRule, timeRule);
    }

    public void dynamicConfig() {
        // todo 监听配置中心变化
        int countRule = 111;
        int timeRule = 2;
        this.ipCounter().setCountRule(countRule);
        this.ipCounter().setTimeRule(timeRule);
    }

}

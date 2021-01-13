package com.py.chain.apache.config;

import com.py.chain.apache.BlacklistCommand;
import com.py.chain.apache.FlowControlCommand;
import com.py.chain.apache.InvokeServiceCommand;
import com.py.chain.apache.ParamCheckCommand;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
@Configuration
public class CommonsChainConfig {

    @Bean
    public Command blackListCommand() {
        return new BlacklistCommand();
    }

    @Bean
    public Command flowControlCommand() {
        return new FlowControlCommand();
    }

    @Bean
    public Command paramCheckCommand() {
        return new ParamCheckCommand();
    }

    @Bean
    public Command invokeServiceCommand() {
        return new InvokeServiceCommand();
    }

    @Bean
    public ChainBase chains() {
        ChainBase chainBase = new ChainBase();
        chainBase.addCommand(blackListCommand());
        chainBase.addCommand(flowControlCommand());
        chainBase.addCommand(paramCheckCommand());
        chainBase.addCommand(invokeServiceCommand());
        return chainBase;
    }
}

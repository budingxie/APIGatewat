package com.py.chain.spring;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
@Order(3)
@Component
public class ParamCheckHandler extends GatewayHandler {

    @Override
    public String process(String request) {
        if (request == null || request.contains("error")) {
            return "param error!";
        }
        GatewayHandler next = getNextHandler();
        if (next == null) {
            return null;
        }
        return next.process(request);
    }
}

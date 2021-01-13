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
@Order(4)
@Component
public class InvokeServiceHandler extends GatewayHandler {

    @Override
    public String process(String request) {
        // invoke service
        String result = "result for request: " + request;
        GatewayHandler next = getNextHandler();
        if (next == null) {
            return null;
        }
        return next.process(request);
    }
}

package com.py.chain.spring;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
public abstract class GatewayHandler {

    protected GatewayHandler nextHandler;

    public abstract String process(String request);

    public GatewayHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(GatewayHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

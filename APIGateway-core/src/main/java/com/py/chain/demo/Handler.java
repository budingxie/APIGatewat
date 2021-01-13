package com.py.chain.demo;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/12
 */
public abstract class Handler {

    protected Handler nextHandler;

    public abstract void process();

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

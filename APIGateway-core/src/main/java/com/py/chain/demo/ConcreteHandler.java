package com.py.chain.demo;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
public class ConcreteHandler extends Handler {
    @Override
    public void process() {
        if (true) {
            // 当前处理者能处理
            return;
        }
        // 交给 下一个处理者
        if (getNextHandler() == null) {
            return;
        }
        getNextHandler().process();
    }
}

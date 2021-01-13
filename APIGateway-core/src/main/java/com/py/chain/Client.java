package com.py.chain;

import com.py.chain.demo.ConcreteHandler;
import com.py.chain.demo.Handler;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
public class Client {
    public static void main(String[] args) {
        // 按照责任链模式的定义，一个请求只能被其中一个请求处理者处理，
        // 或者一个请求处理者都无法处理，但是实际应用中大多数是一个 请求 可以被多个 请求处理者 处理。
        // 责任链模式的应用：Tomcat中的Filter、netty中的Pipeline和ChannelHandler、
        // SpringAop中的Advisor执行Dubbo的过滤链、Mybatis中的插件机制、Zuul中的ZuulFilter

        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        Handler handler3 = new ConcreteHandler();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        handler1.process();
    }
}

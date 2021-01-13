package com.py.chain.apache;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
public class FlowControlCommand extends AbstractCommand {
    @Override
    public boolean execute(CommonContext context) {
        System.out.println("FlowControlCommand...");
        return false;
    }
}

package com.py.chain.apache;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
public class InvokeServiceCommand extends AbstractCommand {
    @Override
    public boolean execute(CommonContext context) {
        System.out.println("InvokeServiceCommand...");
        String request = String.valueOf(context.get("request"));

        String result = "result for request: " + request;
        context.put("result", result);
        return false;
    }
}

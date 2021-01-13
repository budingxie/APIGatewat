package com.py.chain.apache;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
public class ParamCheckCommand extends AbstractCommand {
    @Override
    public boolean execute(CommonContext context) {
        System.out.println("ParamCheckCommand...");
        String request = String.valueOf(context.get("request"));
        if (request.contains("error")) {
            context.put("error", "param error!");
            return true;
        }
        return false;
    }
}

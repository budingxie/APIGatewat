package com.py.chain.apache;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
public class BlacklistCommand extends AbstractCommand {
    @Override
    public boolean execute(CommonContext context) {
        System.out.println("BlacklistCommand...");
        String request = String.valueOf(context.get("request"));
        if (request.contains("hack")) {
            context.put("error", "ip locked");
            return true;
        }
        return false;
    }
}

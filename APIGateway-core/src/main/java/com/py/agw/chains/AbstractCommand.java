package com.py.agw.chains;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
public abstract class AbstractCommand implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        CommonContext commonContext = (CommonContext) context;
        return execute(commonContext);
    }

    public abstract boolean execute(CommonContext context);
}

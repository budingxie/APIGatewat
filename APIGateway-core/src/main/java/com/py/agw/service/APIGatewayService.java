package com.py.agw.service;

import com.py.agw.chains.CommonContext;
import com.py.agw.result.Result;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
public interface APIGatewayService {

    /**
     * 处理请求，调用commons-chain来处理
     *
     * @param context commons-chain使用的上下文
     * @return 调用结果
     */
    Result<String> processRequest(CommonContext context);
}

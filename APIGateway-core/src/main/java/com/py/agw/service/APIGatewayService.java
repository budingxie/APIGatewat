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
    Result<String> processRequest(CommonContext context);
}

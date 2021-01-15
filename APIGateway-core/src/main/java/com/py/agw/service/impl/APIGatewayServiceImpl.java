package com.py.agw.service.impl;

import com.alibaba.fastjson.JSON;
import com.py.agw.chains.CommonContext;
import com.py.agw.result.Result;
import com.py.agw.service.APIGatewayService;
import org.apache.commons.chain.impl.ChainBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.py.agw.model.ErrorCode.SYSTEM_ERROR;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
@Service("apiGatewayService")
public class APIGatewayServiceImpl implements APIGatewayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIGatewayServiceImpl.class);

    @Resource
    private ChainBase chains;

    @Override
    public Result<String> processRequest(CommonContext context) {
        try {
            // commons-chain处理
            chains.execute(context);

            Result<String> result = new Result<>();
            result.setCode(context.getRetCode());
            result.setMsg(context.getRetMsg());
            result.setSuccess(context.getSuccess());
            result.setModel((String) context.getRetModel());
            result.setNonce(context.getRetNonce());
            result.setSign(context.getRetSign());
            return result;
        } catch (Exception e) {
            LOGGER.warn("system error, context: {}, cause: ", JSON.toJSONString(context), e);
            return new Result<>(SYSTEM_ERROR);
        }
    }
}

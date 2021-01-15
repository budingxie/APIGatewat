package com.py.agw.chains;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.py.agw.chains.support.GenericInvokeDubbo;
import com.py.agw.dao.model.OutDO;
import com.py.agw.manager.OutManager;
import com.py.agw.utils.CodecUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.security.SecureRandom;

/**
 * description：泛化调用dubbo服务，将结果加密返回
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/14
 */
public class InvokeServiceCommand extends AbstractCommand{

    private static final Logger LOGGER = LoggerFactory.getLogger(InvokeServiceCommand.class);

    @Resource
    private GenericInvokeDubbo genericInvokeDubbo;

    @Resource
    private OutManager outManager;

    @Override
    public boolean execute(CommonContext context) {
        try {
            String[] paramTypes = context.getParamTypes();
            Object[] params = context.getParams();
            String interfaceClass = context.getApiDO().getName();
            String method = context.getApiDO().getMethod();
            Object object = genericInvokeDubbo.invokeDubbo(interfaceClass, method, paramTypes, params);
            String jsonData = JSON.toJSONString(object, SerializerFeature.WriteNullNumberAsZero);

            String outName = context.getOutName();
            OutDO outDO = outManager.queryByName(outName);

            int nonce = new SecureRandom().nextInt();
            String encryptData = CodecUtil.encrypt(outDO.getCode(), jsonData);


            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}

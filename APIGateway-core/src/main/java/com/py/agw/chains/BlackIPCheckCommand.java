package com.py.agw.chains;

import com.py.agw.manager.BlackIpManager;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static com.py.agw.model.ErrorCode.IP_NOT_ALLOWED;

/**
 * description：检查ip是否在黑名单
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/14
 */
public class BlackIPCheckCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlackIPCheckCommand.class);

    @Resource
    private BlackIpManager blackIpManager;

    @Override
    public boolean execute(CommonContext context) {
        String clientIp = context.getClientIp();
        if (CollectionUtils.isNotEmpty(blackIpManager.queryById(clientIp))) {
            LOGGER.warn("not allowed to access ip: {}", clientIp);
            context.setRetCode(IP_NOT_ALLOWED.getCode());
            context.setRetMsg(IP_NOT_ALLOWED.getMsg());
            context.setSuccess(false);
            return true;
        }
        return false;
    }


}

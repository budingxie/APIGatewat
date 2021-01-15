package com.py.agw.chains;

import com.py.agw.dao.model.*;
import com.py.agw.manager.ApiManager;
import com.py.agw.manager.OutManager;
import com.py.agw.manager.SysManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static com.py.agw.model.ErrorCode.*;

/**
 * description：检查API是不是存在、检查API是不是属于指定的系统、检查API是不是属于调用方、检查调用方白名单
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/13
 */
public class APICheckCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(APICheckCommand.class);

    @Resource
    private ApiManager apiManager;

    @Resource
    private OutManager outManager;

    @Resource
    private SysManager sysManager;

    @Override
    public boolean execute(CommonContext context) {
        String apiCode = context.getApiCode();
        ApiDO apiDO = apiManager.queryByCode(apiCode);
        if (apiDO == null) {
            LOGGER.warn("api not exist, out: {}", apiCode);
            context.setRetCode(API_NOT_EXIST.getCode());
            context.setRetMsg(API_NOT_EXIST.getMsg());
            context.setSuccess(false);
            return true;
        }

        String sysName = context.getSys();
        SysDO sysDO = sysManager.queryByName(sysName);
        if (sysDO == null) {
            LOGGER.warn("sys not exist, sys: {}", sysName);
            context.setRetCode(SYS_NOT_EXIST.getCode());
            context.setRetMsg(SYS_NOT_EXIST.getMsg());
            context.setSuccess(false);
            return true;
        }

        if (!sysDO.getId().equals(apiDO.getSysId())) {
            LOGGER.warn("api not exist, out: {}", apiCode);
            context.setRetCode(API_NOT_EXIST.getCode());
            context.setRetMsg(API_NOT_EXIST.getMsg());
            context.setSuccess(false);
            return true;
        }

        String outName = context.getOutName();
        OutDO outDO = outManager.queryByName(outName);

        OutApiDO outApiDO = outManager.queryByOutIdAndApiId(outDO.getId(), apiDO.getId());
        if (outApiDO == null) {
            LOGGER.warn("out api not exist, out: {}", apiCode);
            context.setRetCode(API_NOT_EXIST.getCode());
            context.setRetMsg(API_NOT_EXIST.getMsg());
            context.setSuccess(false);
            return true;
        }

        if (outDO.getIpControl()) {
            OutIpDO outIpDO = outManager.queryByOutIdAndIp(outDO.getId(), context.getClientIp());
            if (outIpDO == null) {
                LOGGER.warn("not allowed to access ip: {}", context.getClientIp());
                context.setRetCode(IP_NOT_ALLOWED.getCode());
                context.setRetMsg(IP_NOT_ALLOWED.getMsg());
                context.setSuccess(false);
                return true;
            }
        }
        return false;
    }
}

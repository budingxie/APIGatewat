package com.py.agw.chains;

import com.py.agw.dao.model.OutDO;
import com.py.agw.manager.OutManager;
import com.py.agw.utils.CodecUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static com.py.agw.model.ErrorCode.OUT_CHANNEL_NOT_EXIST;
import static com.py.agw.model.ErrorCode.SIGNATURE_ERROR;

/**
 * description：检验签名
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/18
 */
public class SignatureCheckCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignatureCheckCommand.class);

    @Resource
    private OutManager outManager;

    @Override
    public boolean execute(CommonContext context) {

        String outName = context.getOutName();
        OutDO outDO = outManager.queryByName(outName);
        if (outDO == null) {
            LOGGER.warn("out channel not exist, out: {}", outName);
            context.setRetCode(OUT_CHANNEL_NOT_EXIST.getCode());
            context.setRetMsg(OUT_CHANNEL_NOT_EXIST.getMsg());
            context.setSuccess(false);
            return true;
        }

        String data = context.getParam();
        String nonce = context.getNonce();
        String sign = CodecUtil.sign(outDO.getCode(), data, nonce);
        String reqSign = context.getSignature();

        if (!reqSign.equals(sign)) {
            LOGGER.warn("signature error, out: {}", outName);
            context.setRetCode(SIGNATURE_ERROR.getCode());
            context.setRetMsg(SIGNATURE_ERROR.getMsg());
            context.setSuccess(false);
            return true;
        }
        return false;
    }
}

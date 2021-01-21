package com.py.agw.manager;

import com.py.agw.dao.OutApiDao;
import com.py.agw.dao.OutDao;
import com.py.agw.dao.OutIpDao;
import com.py.agw.dao.model.OutApiDO;
import com.py.agw.dao.model.OutDO;
import com.py.agw.dao.model.OutIpDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/13
 */
@Component
public class OutManager {

    @Resource
    private OutDao outDao;

    @Resource
    private OutApiDao outApiDao;

    @Resource
    private OutIpDao outIpDao;

    public OutDO queryByName(String name) {
        return outDao.queryByName(name);
    }

    public OutApiDO queryByOutIdAndApiId(Long outId, Long apiId) {
        return outApiDao.queryByOutIdAndApiId(outId, apiId);
    }

    public OutIpDO queryByOutIdAndIp(Long outId, String clientIp) {
        return outIpDao.queryByOutIdAndIp(outId, clientIp);
    }
}

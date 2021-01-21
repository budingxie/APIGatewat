package com.py.agw.dao;

import com.py.agw.dao.mapper.OutIpDOMapper;
import com.py.agw.dao.model.OutIpDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/19
 */
@Repository
public class OutIpDao {

    @Resource
    private OutIpDOMapper outIpDOMapper;

    public OutIpDO queryByOutIdAndIp(Long outId, String clientIp) {
        return outIpDOMapper.selectByOutIdAndIp(outId, clientIp);
    }
}

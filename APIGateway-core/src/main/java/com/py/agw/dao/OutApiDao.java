package com.py.agw.dao;

import com.py.agw.dao.mapper.OutApiDOMapper;
import com.py.agw.dao.model.OutApiDO;
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
public class OutApiDao {

    @Resource
    private OutApiDOMapper outApiDOMapper;

    public OutApiDO queryByOutIdAndApiId(Long outId, Long apiId) {
        return outApiDOMapper.selectByOutIdAndApiId(outId, apiId);
    }

}

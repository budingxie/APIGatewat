package com.py.agw.dao;

import com.py.agw.dao.mapper.OutDOMapper;
import com.py.agw.dao.model.OutDO;
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
public class OutDao {

    @Resource
    private OutDOMapper outDOMapper;

    public OutDO queryByName(String name) {
        return outDOMapper.selectByName(name);
    }

}

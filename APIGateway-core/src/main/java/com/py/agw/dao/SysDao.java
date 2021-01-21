package com.py.agw.dao;

import com.py.agw.dao.mapper.SysDOMapper;
import com.py.agw.dao.model.SysDO;
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
public class SysDao {

    @Resource
    private SysDOMapper sysDOMapper;

    public SysDO queryByName(String name) {
        return sysDOMapper.selectByName(name);
    }
}

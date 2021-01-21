package com.py.agw.dao;

import com.py.agw.dao.mapper.ApiDOMapper;
import com.py.agw.dao.model.ApiDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * description：
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/19
 */
@Repository
public class ApiDao {

    @Resource
    private ApiDOMapper apiDOMapper;

    public ApiDO queryByCode(String code) {
        return apiDOMapper.selectByCode(code);
    }
}

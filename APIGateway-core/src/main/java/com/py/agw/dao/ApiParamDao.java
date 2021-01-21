package com.py.agw.dao;

import com.py.agw.dao.mapper.ApiParamDOMapper;
import com.py.agw.dao.model.ApiParamDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/19
 */
@Repository
public class ApiParamDao {

    @Resource
    private ApiParamDOMapper apiParamDOMapper;

    public List<ApiParamDO> queryByApiId(Long apiId) {
        return apiParamDOMapper.selectByApiId(apiId);
    }
}

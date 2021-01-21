package com.py.agw.dao.mapper;

import com.py.agw.dao.model.ApiParamDO;

import java.util.List;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/19
 */
public interface ApiParamDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ApiParamDO record);

    int insertSelective(ApiParamDO record);

    ApiParamDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiParamDO record);

    int updateByPrimaryKey(ApiParamDO record);

    List<ApiParamDO> selectByApiId(Long apiId);
}

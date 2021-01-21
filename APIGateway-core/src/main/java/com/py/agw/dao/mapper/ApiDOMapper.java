package com.py.agw.dao.mapper;

import com.py.agw.dao.model.ApiDO;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/19
 */
public interface ApiDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ApiDO record);

    int insertSelective(ApiDO record);

    ApiDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiDO record);

    int updateByPrimaryKey(ApiDO record);

    ApiDO selectByCode(String code);
}

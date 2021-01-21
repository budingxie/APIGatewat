package com.py.agw.dao.mapper;

import com.py.agw.dao.model.SysDO;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/19
 */
public interface SysDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysDO record);

    int insertSelective(SysDO record);

    SysDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDO record);

    int updateByPrimaryKey(SysDO record);

    SysDO selectByName(String name);
}

package com.py.agw.dao.mapper;

import com.py.agw.dao.model.OutDO;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/19
 */
public interface OutDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OutDO record);

    int insertSelective(OutDO record);

    OutDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutDO record);

    int updateByPrimaryKey(OutDO record);

    OutDO selectByName(String name);
}

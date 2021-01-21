package com.py.agw.dao.mapper;

import com.py.agw.dao.model.OutApiDO;
import org.apache.ibatis.annotations.Param;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/19
 */
public interface OutApiDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OutApiDO record);

    int insertSelective(OutApiDO record);

    OutApiDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutApiDO record);

    int updateByPrimaryKey(OutApiDO record);

    OutApiDO selectByOutIdAndApiId(@Param("outId") Long outId, @Param("apiId") Long apiId);
}

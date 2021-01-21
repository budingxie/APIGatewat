package com.py.agw.dao.mapper;

import com.py.agw.dao.model.OutIpDO;
import org.apache.ibatis.annotations.Param;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/19
 */
public interface OutIpDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OutIpDO record);

    int insertSelective(OutIpDO record);

    OutIpDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutIpDO record);

    int updateByPrimaryKey(OutIpDO record);

    OutIpDO selectByOutIdAndIp(@Param("outId") Long outId, @Param("ip") String clientIp);
}

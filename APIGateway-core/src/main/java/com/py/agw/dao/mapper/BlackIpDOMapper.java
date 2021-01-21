package com.py.agw.dao.mapper;

import com.py.agw.dao.model.BlackIpDO;

import java.util.List;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/14
 */
public interface BlackIpDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BlackIpDO record);

    int insertSelective(BlackIpDO record);

    BlackIpDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlackIpDO record);

    int updateByPrimaryKey(BlackIpDO record);

    List<BlackIpDO> selectByIp(String ip);
}

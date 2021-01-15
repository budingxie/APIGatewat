package com.py.agw.dao.mapper;

import com.py.agw.dao.model.BlackIpDO;

import java.util.List;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/14
 */
public interface BlackIpDOMapper {

    List<BlackIpDO> selectById(String ip);
}

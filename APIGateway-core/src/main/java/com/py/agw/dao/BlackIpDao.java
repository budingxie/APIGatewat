package com.py.agw.dao;

import com.py.agw.dao.mapper.BlackIpDOMapper;
import com.py.agw.dao.model.BlackIpDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/14
 */
@Repository
public class BlackIpDao {

    @Resource
    private BlackIpDOMapper blackIpDOMapper;

    public List<BlackIpDO> queryById(String ip) {
        return blackIpDOMapper.selectByIp(ip);
    }
}

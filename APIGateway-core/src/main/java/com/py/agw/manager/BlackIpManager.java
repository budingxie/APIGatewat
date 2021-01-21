package com.py.agw.manager;

import com.py.agw.dao.BlackIpDao;
import com.py.agw.dao.model.BlackIpDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/14
 */
@Component
public class BlackIpManager {

    @Resource
    private BlackIpDao blackIpDao;

    public List<BlackIpDO> queryById(String ip) {
        return blackIpDao.queryById(ip);
    }
}

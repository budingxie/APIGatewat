package com.py.agw.manager;

import com.py.agw.dao.SysDao;
import com.py.agw.dao.model.SysDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/13
 */
@Component
public class SysManager {

    @Resource
    private SysDao sysDao;

    public SysDO queryByName(String name) {
        return sysDao.queryByName(name);
    }
}

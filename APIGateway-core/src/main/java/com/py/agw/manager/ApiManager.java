package com.py.agw.manager;

import com.py.agw.dao.ApiDao;
import com.py.agw.dao.ApiParamDao;
import com.py.agw.dao.model.ApiDO;
import com.py.agw.dao.model.ApiParamDO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/13
 */
@Component
public class ApiManager {

    @Resource
    private ApiDao apiDao;

    @Resource
    private ApiParamDao apiParamDao;

    @Cacheable(value = "apiByCode", key = "#code", unless = "#result == null")
    public ApiDO queryByCode(String code) {
        return apiDao.queryByCode(code);
    }

    public List<ApiParamDO> queryApiParamsByApiId(Long apiId) {
        return apiParamDao.queryByApiId(apiId);
    }
}

package com.py.chain.controller;

import com.alibaba.fastjson.JSON;
import com.py.chain.apache.CommonContext;
import com.py.chain.spring.GatewayHandler;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
@RestController
@RequestMapping("/chain")
public class ChainController {

    @Resource
    private List<GatewayHandler> gatewayHandlers;

    @Resource
    private ChainBase chains;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@RequestParam String str) {
        GatewayHandler defaultHandler = gatewayHandlers.get(0);
        return defaultHandler.process(str);
    }

    @RequestMapping(value = "/commonsChainTest", method = RequestMethod.GET)
    public String commonsChainTest(@RequestParam String str) throws Exception {
        CommonContext commonContext = new CommonContext();
        commonContext.put("request", str);
        System.out.println(chains.execute(commonContext));
        System.out.println(JSON.toJSONString(commonContext));

        String result = commonContext.get("result") == null ? (String) commonContext.get("error") : (String) commonContext.get("result");
        return result;
    }

}

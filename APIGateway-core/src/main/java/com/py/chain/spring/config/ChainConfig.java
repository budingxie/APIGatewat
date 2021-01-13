package com.py.chain.spring.config;

import com.py.chain.spring.GatewayHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * description
 *
 * @author pengyou@xiaomi.com
 * @version 1.0.0
 * @date 2021/1/13
 */
@Configuration
public class ChainConfig {

    @Resource
    private List<GatewayHandler> gatewayHandlers;

    @PostConstruct
    private void initChain() {
        Collections.sort(gatewayHandlers, AnnotationAwareOrderComparator.INSTANCE);

        int size = gatewayHandlers.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                gatewayHandlers.get(i).setNextHandler(null);
            }else {
                gatewayHandlers.get(i).setNextHandler(gatewayHandlers.get(i + 1));
            }
        }
    }
}

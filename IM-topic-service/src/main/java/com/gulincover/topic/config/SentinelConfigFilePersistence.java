package com.gulincover.topic.config;

import com.alibaba.csp.sentinel.init.InitFunc;
import org.springframework.beans.factory.annotation.Value;

public class SentinelConfigFilePersistence implements InitFunc {
    @Value("spring.application.name")
    private String applicationName;
    @Override
    public void init() throws Exception {

    }
}

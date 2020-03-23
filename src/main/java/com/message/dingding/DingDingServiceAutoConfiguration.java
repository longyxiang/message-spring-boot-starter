package com.message.dingding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author vvic
 * @date 2020/3/23
 * @description
 */
@Configuration
@EnableConfigurationProperties(DingDingProperties.class)
@ConditionalOnClass(DingDingService.class)
// matchIfMissing = true spring.dingding 未配置也会加载正常
@ConditionalOnProperty(prefix = "spring.dingding", value = "enabled", matchIfMissing = true)
public class DingDingServiceAutoConfiguration {

    @Autowired
    private DingDingProperties properties;

    @Bean
    @ConditionalOnMissingBean(DingDingService.class) // 当容器中没有指定Bean的情况下，自动配置PersonService类
    public DingDingService personService() {
        return new DingDingServiceImpl(properties);
    }
}

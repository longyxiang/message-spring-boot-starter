package com.message.dingding;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author vvic
 * @date 2020/3/23
 * @description
 */
@ConfigurationProperties(prefix = "spring.dingding")
@Data
public class DingDingProperties {
    /**
     * 钉钉token
     */
    private String token;
    /**
     * web-hook-domain
     */
    private String webHookDomain = "https://oapi.dingtalk.com";
    /**
     * 关键字
     */
    private String key = "异常";
    /**
     * 连接超时
     */
    private int connectTimeoutMillis = 2000;
    /**
     * 读超时
     */
    private int readTimeoutMillis = 3500;
}

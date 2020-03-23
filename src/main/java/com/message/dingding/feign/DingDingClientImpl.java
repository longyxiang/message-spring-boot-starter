package com.message.dingding.feign;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.message.dingding.model.RobotSendRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author vvic
 * @date 2020/3/23
 * @description
 */
@Component
@Slf4j
public class DingDingClientImpl implements DingDingClient {

    @Override
    public Map<String, Object> send(RobotSendRequest request, String token, long timestamp, String sign) {
        log.error("接口调用错误：{}：{}：{}：{}", request, token, timestamp, sign);
        return null;
    }

    @Override
    public Map<String, Object> send(RobotSendRequest request, String token) {
        log.error("接口调用错误：{}：{}", request, token);
        return null;
    }
}

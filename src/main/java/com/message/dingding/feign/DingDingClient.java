package com.message.dingding.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;

import com.message.dingding.model.RobotSendRequest;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author vvic
 * @date 2020/3/23
 * @description
 */
@FeignClient(fallback = DingDingClientImpl.class)
public interface DingDingClient {

    @RequestLine("POST /robot/send?access_token={access_token}&timestamp={timestamp}&sign={sign}")
    @Headers({"Content-Type:application/json;charset=UTF-8"})
    Map<String, Object> send(RobotSendRequest request, @Param("access_token") String token,
        @Param("timestamp") long timestamp, @Param("sign") String sign);

    @RequestLine("POST /robot/send?access_token={access_token}")
    @Headers({"Content-Type:application/json;charset=UTF-8"})
    Map<String, Object> send(RobotSendRequest request, @Param("access_token") String token);
}

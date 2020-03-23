package com.message.dingding;

import java.util.Map;

import com.message.dingding.feign.DingDingClient;
import com.message.dingding.model.RobotSendRequest;

import cn.hutool.core.date.DateUtil;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;

/**
 * @author vvic
 * @date 2020/3/23
 * @description 钉钉消息发送
 */
@Slf4j
public class DingDingServiceImpl implements DingDingService {

    /**
     * 钉钉消息长度最大值
     */
    private static final int MAX_LENGTH = 2000;

    private DingDingClient dingDingClient;

    private DingDingProperties properties;

    public DingDingServiceImpl(DingDingProperties properties) {
        this.properties = properties;
        initDingDingClient();
    }

    private void initDingDingClient() {
        try {
            this.dingDingClient = Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
                .logLevel(Logger.Level.FULL).logger(new Slf4jLogger())
                .options(new Request.Options(properties.getConnectTimeoutMillis(), properties.getReadTimeoutMillis()))
                .target(DingDingClient.class, properties.getWebHookDomain());
        } catch (Exception e) {
            log.error("DingDingService.initDingDingClient()", e);
        }

    }

    /**
     * 发送钉钉消息
     * 
     * @param msg
     *            消息内容
     */
    @Override
    public void send(String msg) {
        try {
            String dingdingMsg = properties.getKey() + " | " + msg;
            log.info("发送钉钉消息：" + dingdingMsg);
            sendByFeign(dingdingMsg);
        } catch (Exception e) {
            log.error("DingDingService.send()异常", e);
        }
    }

    /**
     * 发送钉钉消息，包含堆栈信息
     * 
     * @param context
     */
    @Override
    public void sendStackTrace(String context) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            StackTraceElement[] arr = Thread.currentThread().getStackTrace();
            stringBuilder.append(properties.getKey()).append(" | ");
            stringBuilder.append(DateUtil.now()).append(" | ");
            stringBuilder.append(arr[2].getClassName()).append('(').append(arr[2].getMethodName()).append(':')
                .append(arr[2].getLineNumber()).append(')');
            if (context.length() > MAX_LENGTH) {
                context = context.substring(0, MAX_LENGTH);
            }
            stringBuilder.append(" | ").append(context);
            log.info("发送钉钉消息：" + stringBuilder.toString());
            sendByFeign(stringBuilder.toString());
        } catch (Exception e) {
            log.error("sendDingDing error", e);
        }
    }

    private void sendByFeign(String msg) {
        RobotSendRequest request = new RobotSendRequest(msg);
        Map<String, Object> send = dingDingClient.send(request, properties.getToken());
        if (log.isDebugEnabled()) {
            log.debug("发送结果:{}", send);
        }
    }

}

package com.message.dingding;

/**
 * @author vvic
 * @date 2020/3/23
 * @description
 */
public interface DingDingService {

    /**
     * 发送钉钉消息
     *
     * @param msg
     *            消息内容
     */
    void send(String msg);

    /**
     * 发送钉钉消息，包含堆栈信息
     *
     * @param context
     */
    void sendStackTrace(String context);

}

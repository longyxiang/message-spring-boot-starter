package com.message.dingding.model;

import java.util.List;

import com.message.dingding.constant.MsgType;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author vvic
 * @date 2020/3/23
 * @description
 */
@Data
public class RobotSendRequest {

    private RobotSendRequest.Content text;
    private RobotSendRequest.At at;
    private String msgtype;

    public RobotSendRequest() {}

    public RobotSendRequest(String text) {
        this.text = new RobotSendRequest.Content(text);
        this.at = new RobotSendRequest.At(true, null);
        this.msgtype = MsgType.TEXT.name().toLowerCase();
    }

    @Data
    @AllArgsConstructor
    public static class Content {
        private String content;
    }

    @Data
    @AllArgsConstructor
    public static class At {
        private boolean isAtAll;
        private List<String> atMobiles;
    }
}

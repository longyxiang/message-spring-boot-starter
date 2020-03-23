# message-spring-boot-starter
消息统一集成starter（钉钉、邮件、短信）


# 钉钉消息发送

### 默认配置
```
spring.dingding.token=复制钉钉群的机器人token
spring.dingding.web-hook-domain=https://oapi.dingtalk.com
spring.dingding.key=\u81ea\u6d4b\u5f02\u5e38
spring.dingding.connectTimeoutMillis=2000
spring.dingding.readTimeoutMillis=3500
```
spring.dingding.token：必须配置，复制钉钉群的机器人token

spring.dingding.web-hook-domain：可不用配置，默认为https://oapi.dingtalk.com

spring.dingding.key：可不用配置，默认配置关键字【异常】，因为钉钉群接收消息可以通过关键字来接收

spring.dingding.connectTimeoutMillis：连接超时，默认2000 可不用配置

spring.dingding.readTimeoutMillis：读超时，默认3500 可不用配置

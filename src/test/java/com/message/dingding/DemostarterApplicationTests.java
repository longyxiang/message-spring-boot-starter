package com.message.dingding;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemostarterApplicationTests {

    @Autowired
    private DingDingService dingDingService;

    @Test
    void contextLoads() {
        dingDingService.send("自测忽略");
    }

    @Test
    void test() {
        dingDingService.sendStackTrace("自测忽略");
    }

}

package com.daq.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class logTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void testLog() {
        logger.error("用户为绑定就开始缴费");
    }
}

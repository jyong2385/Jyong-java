package com.jyong.java.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author jyong
 * @Date 2024/3/6 21:32
 * @desc
 */

public class RetryPolicy {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    int maxRetries;
    int delay;

    public void delay(){
        try {
            Thread.sleep(delay);
        }catch (Exception ex){
            logger.error("sleep error",ex);
        }
    }

}

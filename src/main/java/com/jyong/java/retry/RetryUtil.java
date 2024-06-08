package com.jyong.java.retry;

/**
 * @Author jyong
 * @Date 2024/3/6 21:33
 * @desc 重试机制
 */

public class RetryUtil {

    public static <T> T retry(RetryCallable<T> callable, RetryPolicy retryPolicy) {
        int retries = 0;
        while (true) {
            try {
                callable.call();
            } catch (Exception ex) {
                if (retries >= retryPolicy.maxRetries) {
                    throw ex;
                }

                //等待
                retryPolicy.delay();
                //重试次数+1
                retries++;
            }
        }
    }

}

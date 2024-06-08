package com.jyong.java.retry;

/**
 * @Author jyong
 * @Date 2024/3/6 21:31
 * @desc 重试机制
 */

public interface RetryCallable<T> {

    /**
     * 请求执行的函数接口
     * @return
     */
    T call();
}

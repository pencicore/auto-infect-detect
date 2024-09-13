package com.infect.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 成员变量：
 * lastTime：记录上次发放令牌的时间。
 * capacity：桶的最大容量，默认为2。
 * rate：令牌发放速率，默认每秒2个令牌。
 * tokens：当前桶中的令牌数量，使用AtomicInteger保证线程安全。
 * 方法isLimited：
 * 参数：taskId任务ID，applyCount请求需要的令牌数量。
 * 返回值：true表示请求被限流，false表示未被限流。
 * 功能：根据令牌桶算法判断请求是否被限流，并更新令牌数量。初始化时打印初始化信息。
 */

public class TokenBucketLimiter {
    //上一次令牌发放时间
    public long lastTime = 0;
    //桶的容量
    public int capacity = 2;
    //令牌发放速率
    public int rate = 2;
    //当前令牌数量
    public AtomicInteger tokens = new AtomicInteger(0);

    //返回值说明
    //false 表示没有被限流
    //true 表示被限流
    public synchronized boolean isLimited(long taskId, int applyCount) {
        long now = System.currentTimeMillis();
        long gap = now - lastTime;

        if (lastTime!=0 && gap < 1000){
            if (tokens.get() < applyCount){
                //若拿不到令牌就拒接
                return true;
            }else{
                //拿到令牌
                tokens.addAndGet(-applyCount);
                return false;
            }
        }
        System.out.println("taskId:"+taskId+" 令牌桶限流器初始化"+"当前令牌数量:"+tokens.get());
        if ( lastTime == 0){
            gap = 1000;
        }
        //计算当前时间段令牌数量
        int reverse_permits = (int) (gap * rate / 1000);
        if (reverse_permits > 0){
            //当前时间段令牌数量
            tokens.addAndGet(reverse_permits);
            if (tokens.get() > capacity){
                tokens.set(capacity);
            }
        }
        int all_permits = tokens.get()+ reverse_permits;
        tokens.set(Math.min(capacity, all_permits));
        lastTime = now;
        if (tokens.get()<applyCount){
            //若拿不到令牌就拒接
            return true;
        }else{
            //拿到令牌
            tokens.getAndAdd(-applyCount);
            return false;
        }
    }
}

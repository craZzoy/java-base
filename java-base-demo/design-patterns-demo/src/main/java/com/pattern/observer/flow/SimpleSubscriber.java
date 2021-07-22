package com.pattern.observer.flow;

import java.util.concurrent.Flow;

/**
 * @Description: 订阅者
 * @Author : 郑玮泽
 * @Date : 11:15 2020/9/21
 */
public class SimpleSubscriber implements Flow.Subscriber<Long> {

    private Flow.Subscription subscription;

    // Subscriber name
    private String name = "Unknown";

    //此订阅者处理的元素最大数量
    private final long maxCount;

    private long counter;

    public SimpleSubscriber(String name, long maxCount) {
        this.name = name;
        this.maxCount = maxCount <= 0 ? 1 : maxCount;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.printf("%s subscribed with max count %d.%n", name, maxCount);
        //一次请求所有元素，push模式
        subscription.request(maxCount);
    }

    /**
     * 处理元素
     * @param item
     */
    @Override
    public void onNext(Long item) {
        counter++;
        System.out.printf("%s received %d.%n", name, item);
        if (counter >= maxCount) {
            System.out.printf("Cancelling %s. Processed item count: %d.%n", name, counter);
            // Cancel the subscription
            subscription.cancel();
        }
    }

    @Override
    public void onError(Throwable t) {
        System.out.printf("An error occurred in %s: %s.%n", name, t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.printf("%s is complete.%n", name);
    }
}

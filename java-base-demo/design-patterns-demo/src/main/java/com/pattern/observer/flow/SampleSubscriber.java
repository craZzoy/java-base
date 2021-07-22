package com.pattern.observer.flow;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 9:57 2020/9/21
 */
public class SampleSubscriber<T> implements Flow.Subscriber<T> {

    final Consumer<? super T> consumer;

    Flow.Subscription subscription;

    final long bufferSize;

    long count;

    public SampleSubscriber(Consumer<? super T> consumer, long bufferSize) {
        this.consumer = consumer;
        this.bufferSize = bufferSize;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        long initialRequestSize = bufferSize;
        count = bufferSize - bufferSize / 2; // re-request when half consumed
        (this.subscription = subscription).request(initialRequestSize);
    }

    @Override
    public void onNext(T item) {
        if (--count <= 0)
            subscription.request(count = bufferSize - bufferSize / 2);
        consumer.accept(item);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {

    }
}

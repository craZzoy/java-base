package com.pattern.observer.flow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 9:34 2020/9/21
 */
public class OneShotPublisher implements Flow.Publisher<Boolean> {

    private final ExecutorService executor = ForkJoinPool.commonPool();

    private boolean subscribed; // true after first subscribe

    @Override
    public void subscribe(Flow.Subscriber<? super Boolean> subscriber) {
        if (subscribed) {
            subscriber.onError(new IllegalStateException()); // only one allowed
        } else {
            subscribed = true;
            subscriber.onSubscribe(new OneShotSubscription(executor, subscriber));
        }
    }


    static class OneShotSubscription implements Flow.Subscription {

        private final ExecutorService executor;

        private final Flow.Subscriber<? super Boolean> subscriber;

        private Future<?> future; // to allow cancellation

        private boolean completed;

        public OneShotSubscription(ExecutorService executor, Flow.Subscriber<? super Boolean> subscriber) {
            this.executor = executor;
            this.subscriber = subscriber;
        }

        @Override
        public void request(long n) {
            if (!completed) {
                completed = true;
                if (n <= 0) {
                    IllegalArgumentException ex = new IllegalArgumentException();
                    executor.execute(() -> subscriber.onError(ex));
                } else {
                    future = executor.submit(() -> {
                        subscriber.onNext(Boolean.TRUE);
                        subscriber.onComplete();
                    });
                }
            }
        }

        @Override
        public void cancel() {
            completed = true;
            if (future != null) future.cancel(false);
        }

    }

}

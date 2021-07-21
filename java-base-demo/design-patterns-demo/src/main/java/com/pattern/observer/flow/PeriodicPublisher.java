package com.pattern.observer.flow;

import java.util.Random;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 11:31 2020/9/21
 */
public class PeriodicPublisher {

    final static int MAX_SLEEP_DURATION = 3;
    // Used to generate sleep time
    final static Random sleepTimeGenerator = new Random();

    public static void main(String[] args) {
        SubmissionPublisher<Long> pub = new SubmissionPublisher<>();
        //创建订阅者
        SimpleSubscriber sub1 = new SimpleSubscriber("Sub1", 2);
        SimpleSubscriber sub2 = new SimpleSubscriber("Sub2", 5);
        SimpleSubscriber sub3 = new SimpleSubscriber("Sub3", 6);
        SimpleSubscriber sub4 = new SimpleSubscriber("Sub4", 10);
        //增加订阅者
        pub.subscribe(sub1);
        pub.subscribe(sub2);
        pub.subscribe(sub3);
        //两秒后再增加
        subscribe(pub, sub4, 2);

        //发布元素
        Thread pubThread = publish(pub, 5);
        try {
            // Wait until the publisher is finished
            pubThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Thread publish(SubmissionPublisher<Long> pub, long count) {
        Thread t = new Thread(() -> {
            for (long i = 1; i <= count; i++) {
                pub.submit(i);
                sleep(i);
            }
            // Close the publisher
            pub.close();
        });
        // Start the thread
        t.start();
        return t;
    }

    private static void sleep(Long item) {
        // Wait for 1 to 3 seconds
        int sleepTime = sleepTimeGenerator.nextInt(MAX_SLEEP_DURATION) + 1;
        try {
            System.out.printf("Published %d. Sleeping for %d sec.%n", item, sleepTime);
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void subscribe(SubmissionPublisher<Long> pub, SimpleSubscriber sub4, int i) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(i);
                pub.subscribe(sub4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}

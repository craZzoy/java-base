package com.pattern.observer.flow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.LongStream;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 10:48 2020/9/21
 */
public class NumberPrinter {

    public static void main(String[] args) {
        CompletableFuture<Void> subTask = null;

        //try块关闭后pub会自动关闭
        try (SubmissionPublisher<Long> pub = new SubmissionPublisher<>()) {
            //每个订阅者缓冲区大小
            System.out.println("Subscriber Buffer Size: " + pub.getMaxBufferCapacity());
            //增加消费者
            subTask = pub.consume(System.out::println);
            LongStream.range(1L, 6L).forEach(pub::submit);
        }

        if (subTask != null){
            try {
                subTask.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}

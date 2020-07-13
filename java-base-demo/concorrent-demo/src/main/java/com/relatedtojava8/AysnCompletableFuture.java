package com.relatedtojava8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description: 异步执行任务
 * @Author : 郑玮泽
 * @Date : 17:24 2020/7/6
 */
public class AysnCompletableFuture {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> calc(50));
                System.out.println(future.get());*/

        //流式调用
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> calc(50))
                .thenApply(i -> Integer.toString(i))
                .thenApply(s -> "\"" + s + "\"")
                .thenAccept(System.out::println);
        future.get();
    }

    private static Integer calc(int i) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i * i ;
    }
}

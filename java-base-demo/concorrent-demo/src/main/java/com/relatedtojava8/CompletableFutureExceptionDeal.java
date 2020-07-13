package com.relatedtojava8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description: Completable异常处理
 * @Author : 郑玮泽
 * @Date : 17:24 2020/7/6
 */
public class CompletableFutureExceptionDeal {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> calc(50))
                .exceptionally(throwable -> {
                    System.out.println(throwable.toString());
                    return 0;
                })
                .thenApply(i -> Integer.toString(i))
                .thenApply(s -> "\"" + s + "\"")
                .thenAccept(System.out::println);
        future.get();
    }

    private static Integer calc(int i) {
        return i / 0 ;
    }
}

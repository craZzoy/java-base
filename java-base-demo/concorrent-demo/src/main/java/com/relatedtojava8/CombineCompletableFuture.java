package com.relatedtojava8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description: 组合的CompletableFuture
 * @Author : 郑玮泽
 * @Date : 9:56 2020/7/7
 */
public class CombineCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //thenCompose
        CompletableFuture<Void> fu = CompletableFuture
                .supplyAsync(() -> calc(50))
                .thenCompose(i -> {
                    //接收上一个CompletableFuture执行的结果
                    System.out.println(i);
                    return CompletableFuture.supplyAsync(() -> calc(i));
                })
                .thenApply(s -> "\"" + s + "\"")
                .thenAccept(System.out::println);

        //thenCombine
        CompletableFuture<Integer> fu1 = CompletableFuture.supplyAsync(() -> calc(50));
        CompletableFuture<Integer> fu2 = CompletableFuture.supplyAsync(() -> calc(40));
        //根据fu1和fu2的计算结果处理
        CompletableFuture<Void> voidCompletableFuture = fu1.thenCombine(fu2, (i, j) -> (i + j))
                .thenApply(s -> "\"" + s + "\"")
                .thenAccept(System.out::println);


        fu.get();
        voidCompletableFuture.get();
    }

    private static Integer calc(int i) {
        return i / 2 ;
    }

}

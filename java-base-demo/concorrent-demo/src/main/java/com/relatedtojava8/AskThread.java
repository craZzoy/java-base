package com.relatedtojava8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description: 计算
 * @Author : 郑玮泽
 * @Date : 16:36 2020/7/6
 */
public class AskThread implements Runnable{

    CompletableFuture<Integer> cf = null;

    public AskThread(CompletableFuture<Integer> cf) {
        this.cf = cf;
    }

    @Override
    public void run() {
        try {
            System.out.println(cf.get() * cf.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        //模拟future的耗时计算
        Thread.sleep(2000);
        //手动设置future的完成状态
        future.complete(20);
    }
}

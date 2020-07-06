package com.concurrent.pattern.future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Description: 执行类
 * @Author : 郑玮泽
 * @Date : 10:53 2020/7/3
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new RealData("name"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(task);
        System.out.println("数据"  + task.get());
    }
}

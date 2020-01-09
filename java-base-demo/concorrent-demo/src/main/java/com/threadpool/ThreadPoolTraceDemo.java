package com.threadpool;

import java.util.concurrent.*;

public class ThreadPoolTraceDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor executor = new TraceThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                0L,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>()
        );
        for (int i = 0; i < 5; i++) {
            //submit丢失了除0的异常信息
            executor.submit(new DivTask(100, i));
            //处理方式1，这种方式每个任务都能执行
            //executor.execute(new DivTask(100,i));
            //处理方式2，这种方式发生异常后后面任务都不能执行
            /*Future<?> future = executor.submit(new DivTask(100, i));
            future.get();*/
        }
    }
}


class DivTask implements Runnable {
    int a, b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public void run() {
        System.out.println(a / b);
    }
}
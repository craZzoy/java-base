package com.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Long> {

    //每个线程计算数
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        //是否不需拆分为多个线程执行
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= this.end; i++) {
                sum += i;
            }
        } else {
            long step = (end - start + 1) % THRESHOLD == 0 ? (end - start + 1) / THRESHOLD : (end - start + 1) / THRESHOLD + 1;
            List<CountTask> tasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < step; i++) {
                long lastOne = pos + THRESHOLD - 1;
                if (lastOne > end) {
                    lastOne = end;
                }
                CountTask task = new CountTask(pos, end);
                pos += THRESHOLD;
                tasks.add(task);
                task.fork();
            }
            for (CountTask task : tasks) {
                sum += task.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(0, 200000L);
        ForkJoinTask<Long> result = pool.submit(task);
        System.out.println("sum=" + result.get());
    }
}

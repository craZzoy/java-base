package com.threadpool;

import java.util.concurrent.*;

public class TraceThreadPoolExecutor extends ThreadPoolExecutor {

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, cilentTrace(), Thread.currentThread().getName()));
    }

    private Exception cilentTrace() {
        return new Exception("client trace");
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, cilentTrace(), Thread.currentThread().getName()));
    }

    private Runnable wrap(final Runnable task, Exception clientTrace, String threadName) {
        return () -> {
            try {
                task.run();
            } catch (Exception e) {
                e.printStackTrace();
                //clientTrace.printStackTrace();
            }
        };
    }
}

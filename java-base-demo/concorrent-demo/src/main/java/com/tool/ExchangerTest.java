package com.tool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExchangerTest {

    private static final Exchanger<String> exchanger = new Exchanger<String>();

    private static Executor threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            String A = "银行流水a";
            try {
                String exchange = exchanger.exchange(A);
                System.out.println("从B中交换过来的数据：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            String B = "银行流水b";
            try {
                String exchange = exchanger.exchange(B);
                System.out.println("从A中交换过来的数据：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}

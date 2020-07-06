package com.concurrent.pattern.future.jdk;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Description: 真实数据
 * @Author : 郑玮泽
 * @Date : 10:51 2020/7/3
 */
public class RealData implements Callable<String> {

    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        //模拟构造数据很慢的过程
        Random random  = new Random();
        int size = random.nextInt() % 10;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            buffer.append(para);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}

package com.concurrent.pattern.future;

import java.util.Random;

/**
 * @Description: 真实数据
 * @Author : 郑玮泽
 * @Date : 9:54 2020/7/3
 */
public class RealData implements Data{

    protected final String result;

    public RealData(String result) {
        //模拟构造数据很慢的过程
        Random random  = new Random();
        int size = random.nextInt() % 10;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            buffer.append(result);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.result = buffer.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}

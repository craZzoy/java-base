package com.concurrent.pattern.future;

/**
 * @Description: 客户端
 * @Author : 郑玮泽
 * @Date : 10:18 2020/7/3
 */
public class Client {

    public Data request(final String queryStr){
        FutureData futureData = new FutureData();
        new Thread(()->{
            //单独的线程中获取真是数据
            RealData realData = new RealData(queryStr);
            futureData.setRealData(realData);
        }).start();
        return futureData;
    }
}

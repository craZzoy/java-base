package com.concurrent.pattern.future;

/**
 * @Description: 执行类
 * @Author : 郑玮泽
 * @Date : 10:22 2020/7/3
 */
public class FutureMain {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕");
        //Thread.sleep(2000);
        //获取真实数据
        System.out.println("真实数据：" + data.getResult());
    }
}

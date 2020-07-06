package com.pattern.singleton;

/**
 * @Description: 普通单例，饿汉模式
 * 这种情况STATUS被引用时会引起singleton的创建
 * @Author : 郑玮泽
 * @Date : 14:51 2020/7/2
 */
public class Singleton {

    public static int STATUS = 1;

    private Singleton(){
        System.out.println("singleton is create");
    }

    private static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        //未获取单例的情况下也创建了
        System.out.println(Singleton.STATUS);
    }

}

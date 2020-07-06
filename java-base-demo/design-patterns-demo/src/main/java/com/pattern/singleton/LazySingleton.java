package com.pattern.singleton;

/**
 * @Description: 懒汉式单例
 * 锁竞争激烈的情况下会对性能产生一定影响
 * @Author : 郑玮泽
 * @Date : 14:57 2020/7/2
 */
public class LazySingleton {

    private LazySingleton(){
        System.out.println("singleton is create");
    }

    private static LazySingleton instance = null;

    public synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

}

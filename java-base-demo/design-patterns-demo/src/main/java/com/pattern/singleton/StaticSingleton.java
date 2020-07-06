package com.pattern.singleton;

/**
 * @Description: 延迟加载的单例，结合了前面两者的优点
 * @Author : 郑玮泽
 * @Date : 14:46 2020/7/2
 */
public class StaticSingleton {

    private StaticSingleton(){
        System.out.println("StaticSingleton is Create");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        StaticSingleton.getInstance();
    }
}

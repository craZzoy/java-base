package com.pattern.singleton;

/**
 * @Description: 双重检验锁
 * @Author : 郑玮泽
 * @Date : 8:52 2021/5/17
 */
public class DoubleCheckSingleton {

    //private static DoubleCheckSingleton instance = null;

    //解决方案，volatile关键字修饰
    private volatile static DoubleCheckSingleton instance = null;

    public static DoubleCheckSingleton getInstance(){
        //在获取锁之前，检验instance是否为空，减少获取锁的次数，从而提升性能。但实际上可能由于指令重拍，instance可能还在初始化之前就已经分配了内存。这种情况下可以通过加volatile解决
        if (instance == null){
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(DoubleCheckSingleton.getInstance());
    }

}

package com.thread;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 9:04 2021/7/22
 */
public class ThreadLocalDemo {


    private static ThreadLocal<String> threadIdContext = new ThreadLocal<>();


    private static TestClass testClass = new TestClass();

    public static void main(String[] args) {
        //ThreadLocal<String> threadIdContext = new ThreadLocal<>();
        threadIdContext.set(Thread.currentThread().getName());
        threadIdContext.set(Thread.currentThread().getName() + "1");
        System.out.println(threadIdContext.get());
        testClass.echoThis();

        Thread t1 = new Thread(()-> {
           threadIdContext.set(Thread.currentThread().getName());
            System.out.println(threadIdContext.get());
            testClass.echoThis();
        });

        Thread t2 = new Thread(()-> {
            threadIdContext.set(Thread.currentThread().getName());
            System.out.println(threadIdContext.get());
            testClass.echoThis();
        });

        t1.start();
        t2.start();

    }


    static class TestClass {

        public void echoThis(){
            System.out.println(this);
        }

    }

}

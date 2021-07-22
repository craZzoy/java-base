package com.test.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Description: 引用队列测试
 * @Author : 郑玮泽
 * @Date : 9:00 2021/7/21
 */
public class ReferenceQueueTest {

    public static void main(String[] args) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        for (int i = 0; i < 10000000; i++) {
            WeakReference<Object> objectWeakReference  = new WeakReference<Object>(new Object(), referenceQueue);
        }

        System.out.println("队列中对象：" + referenceQueue.poll());
    }

}

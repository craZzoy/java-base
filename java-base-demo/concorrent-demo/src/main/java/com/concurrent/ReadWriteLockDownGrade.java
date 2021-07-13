package com.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 读写锁降级
 * @Author : 郑玮泽
 * @Date : 15:34 2021/4/15
 */
public class ReadWriteLockDownGrade {

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
        lockDownGrade();
        
        lockUpGrade();
    }

    /**
     * 锁升级（不支持）
     */
    private static void lockUpGrade() {
        readLock.lock();
        writeLock.lock();
        try {
            System.out.println("doing something...");
        } finally {
            readLock.unlock();
            writeLock.unlock();
        }
    }

    /**
     * 锁降级
     */
    private static void lockDownGrade() {
        writeLock.lock();
        readLock.lock();
        try {
            System.out.println("doing something...");
        } finally {
            writeLock.unlock();
            readLock.unlock();
        }
    }
    
    

}

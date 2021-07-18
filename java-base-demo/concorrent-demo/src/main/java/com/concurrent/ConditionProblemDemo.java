package com.concurrent;

import javax.management.relation.RoleUnresolved;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 11:47 2021/5/12
 */
public class ConditionProblemDemo implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();


    public static void main(String[] args) {
        new Thread(new ConditionProblemDemo()).start();
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("获得到锁");
            condition.await(3, TimeUnit.SECONDS);
            System.out.println("等待时间已到。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

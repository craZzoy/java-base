package com.concurrent.collection;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class HashMapCompareToHashTable {

    public static void main(String[] args) throws InterruptedException {
        testHashTable(100000);
        testConcurrentHashMap(100000);
    }

    private static void testConcurrentHashMap(int time) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(new Job(new ConcurrentHashMap<>(), time, countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.printf("ConcurrentHashMap %d 个元素花费的时间为 %d ms", time, System.currentTimeMillis()-l);
    }

    private static void testHashTable(int time) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(new Job(new Hashtable<Integer, Integer>(), time, countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.printf("HashTable增加 %d 个元素花费的时间为 %d ms %n", time, System.currentTimeMillis()-l);
    }

    static class Job implements Runnable {

        private Map<Integer, Integer> map;

        private Integer size;

        private CountDownLatch countDownLatch;

        public Job(Map<Integer, Integer> map, Integer size, CountDownLatch countDownLatch) {
            this.map = map;
            this.size = size;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            while (map.size() < size) {
                map.put(map.size(), map.size());
            }
            countDownLatch.countDown();
        }
    }

}

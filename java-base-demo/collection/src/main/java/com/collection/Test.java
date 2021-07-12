package com.collection;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Test {

    public static void main(String[] args) {
        debugConcurrentLinkedQueue();


        int t = 1;
        int tail = 2;
        System.out.println(t != (t = tail) ? t : -1);


        System.out.println(Objects.hash(null));
        System.out.println(1 << 16);
    }

    private static void debugConcurrentLinkedQueue() {

        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue();
        concurrentLinkedQueue.offer(2);

    }

}

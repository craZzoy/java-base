package com.optimize;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo2 implements Runnable{

    private static final ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();

    int i = 0;

    public ThreadLocalDemo2(int i){
        this.i = i;
    }

    @Override
    public void run() {
        try {
            if(t1.get() == null){
                t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
            Date t = t1.get().parse("2020-06-28 22:12:" + i % 60);
            System.out.println(i + ":" + t.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++){
            executorService.submit(new ThreadLocalDemo2(i));
        }
    }
}

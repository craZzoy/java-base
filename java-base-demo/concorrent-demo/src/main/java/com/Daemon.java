package com;

public class Daemon {

    public static void main(String[] args) {
        Thread daemonRunner = new Thread(new DaemonRunner(), "DaemonRunner");
        daemonRunner.setDaemon(true);
        daemonRunner.start();
        System.out.println(daemonRunner.isInterrupted());
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }

}

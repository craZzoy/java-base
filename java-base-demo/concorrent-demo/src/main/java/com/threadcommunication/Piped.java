package com.threadcommunication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 线程间通信-管道，是在内存间通信
 */
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();
        out.connect(in);
        Thread printThead = new Thread(new Print(in), "PrintThead");
        printThead.start();
        int receive = 0;
        try {
            while ((receive = in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable {

        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1){
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

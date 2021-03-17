package com.demo;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Stack;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 9:18 2021/2/25
 */
public class StackDemo {

    public static void main(String[] args) {



    }


    public static Integer compute(Integer n) {
        Stack<Record> stack = new Stack();
        stack.push(new Record(n, 1));
        return 1;
    }

    public static class Record{

        private Integer value;

        private Integer type;

        public Record(Integer value, Integer type) {
            this.value = value;
            this.type = type;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }


}

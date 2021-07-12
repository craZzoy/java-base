package com.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicFieldUpdaterTest {

    //创建原子类更新器
    static AtomicIntegerFieldUpdater<NewUser> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(NewUser.class, "age");

    public static void main(String[] args) {
        NewUser conn = new NewUser("小爱", 100);
        System.out.println(fieldUpdater.getAndIncrement(conn));
        System.out.println(fieldUpdater.get(conn));
    }

    static class NewUser{

        private String name;

        //需要设置 public volatile
        public volatile int age;

        public NewUser(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}

package com.base;

public class SuperClassTest {

    class Parent{
        private String name;

        public Parent(String name) {
            this.name = name;
        }
    }

    class Child extends Parent{
        private String name;

        public Child(String name) {
            super(name);
            this.name = name;
        }
    }

}

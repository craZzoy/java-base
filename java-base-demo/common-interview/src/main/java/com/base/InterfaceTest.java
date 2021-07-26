package com.base;

import java.io.Serializable;

public class InterfaceTest {


    interface InterfaceA extends Serializable, Cloneable {

        Integer intv = 0;

        default void echo(){
            System.out.println("echo");
        }

    }

    abstract class AbstractClass implements InterfaceA{

    }

}

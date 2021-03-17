package com.optional;

import com.entity.Car;
import com.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 14:01 2021/3/17
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(getCarInsuranceNameUnsafely(person));
    }


    /**
     * 不安全地获取对象属性
     * @param person
     * @return
     */
    public static String getCarInsuranceNameUnsafely (Person person){
        return person.getCar().getInsurance().getName();
    }




}

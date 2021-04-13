package com.optional;

import com.entity.Car;
import com.entity.Insurance;
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
        //System.out.println(getCarInsuranceNameUnsafely(person));

        Person p = null;
        Optional<Person> person1 = Optional.ofNullable(p).map(p1 -> p1);
    }


    /**
     * 不安全地获取对象属性
     * @param person
     * @return
     */
    public static String getCarInsuranceNameUnsafely (Person person){
        return person.getCar().getInsurance().getName();
    }


    /**
     * 两个Optional对象组合
     */

    /**
     * 找到最便宜的保险公司
     * @param person
     * @param car
     * @return
     */
    public static Insurance findCheapestInsurance(Person person, Car car){
        //查询数据，对比
        return new Insurance();
    }



}

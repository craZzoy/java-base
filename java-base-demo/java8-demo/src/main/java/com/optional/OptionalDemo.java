package com.optional;

import com.entity.Insurance;
import com.entity.Person;

import java.util.Optional;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 14:01 2021/3/17
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Person person = new Person();
        //System.out.println(getCarInsuranceNameUnsafely(person));

        testSimpleMap();
    }


    /**
     * 不安全地获取对象属性
     * @param person
     * @return
     */
    public static String getCarInsuranceNameUnsafely (Person person){
        return person.getCar().getInsurance().getName();
    }


    public static void testSimpleMap(){
        Insurance insurance = new Insurance();
        final Optional<Insurance> insurance1 = Optional.ofNullable(insurance);
        //insurance1 允许为空
        final Optional<String> s = insurance1.map(Insurance::getName);
        System.out.println(s.orElse("Deafult"));
    }




}

package com.mybatis.resource;

import org.apache.ibatis.io.ClassLoaderWrapper;

import java.net.URL;

public class UrlTest {

    public static void main(String[] args) {
        UrlTest urlTest = new UrlTest();
        URL resource = urlTest.getClass().getResource("mybatis-config.xml");
        URL resource0 = urlTest.getClass().getResource("/mybatis-config.xml");
        URL resource1 = urlTest.getClass().getResource("/");
        System.out.println(resource);
        System.out.println(resource0);
        System.out.println(resource1);
    }

}

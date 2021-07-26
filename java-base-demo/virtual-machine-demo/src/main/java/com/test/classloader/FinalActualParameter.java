package com.test.classloader;

import java.util.List;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 16:51 2021/7/26
 */
public class FinalActualParameter {


    void changeValue(int a){
        a = 2;
    }


    String reloadMethod1(List<String> str){
        return "sss";
    }

    int reloadMethod(List<Integer> integerList){
        return 0;
    }

}

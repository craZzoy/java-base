package com.basicvar;

/**
 * @Description:
 * @Author : 郑玮泽
 * @Date : 17:03 2021/7/22
 */
public class CharTest {

    public static void main(String[] args) {
        char c = '汉';
        byte byteV = (byte) c;
        short shortV = (short) c;
        int intV = c;
        long longV = c;
        //不能强转为String
        //String strV = (String) c;
        String strV = c + "";
        System.out.println(c);
        System.out.printf("byteV：%d\n",byteV);
        System.out.printf("shortV：%d\n",shortV);
        System.out.printf("intV：%d\n",intV);
        System.out.printf("longV：%d\n",longV);
        System.out.printf("strV：%s\n",strV);
    }

}

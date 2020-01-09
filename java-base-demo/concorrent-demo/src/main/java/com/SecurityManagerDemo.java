package com;

import java.lang.SecurityManager;
import java.util.*;

public class SecurityManagerDemo {
    public static void main(String[] args) {
        System.out.println(Math.pow(16, 2));

        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int res = 0;
        for (int i = 2; i < str.length(); i++) {
            System.out.println(getNum(str.charAt(i)));
            res += getNum(str.charAt(i)) * Math.pow(16, (str.length() - 1 - i));
        }
        System.out.println(res);
    }

    public static int getNum(char c) {
        switch (c) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return c - '0';
        }
    }
}

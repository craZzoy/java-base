package com;

import java.math.BigDecimal;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = null;
        while (input.hasNext()) {
            str = input.nextLine();
            int index = 0;
            for (int i = 0; i < str.length(); i++) {
                //System.out.println(str.charAt(i) - '0');
                if ((str.charAt(i) - '0' < 0
                        || (str.charAt(i) - '0' > 9))
                        && str.charAt(i) != '.') {
                    index = i;
                }
            }
            System.out.println(mul(new BigDecimal(str.substring(0, index)),
                    new BigDecimal(str.substring(index + 1, str.length())), str.charAt(index)));
        }
    }

    public static BigDecimal mul(BigDecimal a, BigDecimal b, char f) {
        switch (f) {
            case '+':
                return a.add(b);
            case '-':
                return a.subtract(b);
            case '*':
                return a.multiply(b);
            case '/':
                return a.divide(b);
        }
        return new BigDecimal(0);
    }

}

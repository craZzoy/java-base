package com.niukewang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 寻找质数因子
 */
public class PrimeFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long l = 0;
        while (input.hasNext()) {
            l = input.nextLong();
            List<Long> res = new ArrayList<>();
            for (long i = 2; i < l; i++) {
                long remain = l;
                while (isPrime(i) && remain % i == 0) {
                    res.add(i);
                    remain = remain / i;
                }

                if (resFind(res, l)) {
                    break;
                }
            }
            for (Long l1 : res) {
                System.out.println(l1);
            }
        }

    }

    private static boolean resFind(List<Long> res, long l) {
        long muti = 1;
        for (long i : res) {
            muti *= i;
        }
        if (muti == l) {
            return true;
        }
        return false;
    }

    public static boolean isPrime(long l) {
        for (long i = 2; i < l; i++) {
            if (l % i == 0 && i != 1 && i != l) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }
}

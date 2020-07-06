package com.concurrent.pattern.sort;

import java.util.Arrays;

/**
 * @Description: 奇偶交换排序串行实现
 * @Author : 郑玮泽
 * @Date : 10:15 2020/7/6
 */
public class OddEvenSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,7,30,4,7,20};
        oddEvenSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void oddEvenSort(int[] arr){
        //数据交换标识
        int exchangeFlag = 1;

        int start = 0;
        while (exchangeFlag == 1 || start == 1) {
            exchangeFlag = 0;
            for(int i = start; i < arr.length - 1; i += 2){
                if (arr[i] > arr[i + 1]){
                    arr[i] = arr[i] + arr[i + 1];
                    arr[i + 1] = arr[i] - arr[i + 1];
                    arr[i] = arr[i] - arr[i + 1];
                    exchangeFlag = 1;
                }
            }
            if (start == 1){
                start = 0;
            } else {
                start = 1;
            }
        }
    }
}

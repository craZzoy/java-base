package com.password;

import java.util.ArrayList;
import java.util.List;

public class KaiSaPassword {

    public static List<Character> ccs = new ArrayList<>();

    static {
        for (int i = 0; i < 26; i++) {
            ccs.add(new Character((char) (i + 65)));
        }
    }

    public static void main(String[] args) {
        resolvePassword("BRVKLNR");
        System.out.println('A' + 0);
        System.out.println((char) ('R' + 32));
    }

    /**
     * 穷举法破解凯撒密码
     *
     * @param str
     */
    public static void resolvePassword(String str) {
        for (int i = 0; i < 26; i++) {
            System.out.println(parse(str, i).toLowerCase());
        }
    }

    /**
     * @param str       原始字符
     * @param secretKey 移动位数
     * @return
     */
    private static String parse(String str, int secretKey) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            cs[i] = ccs.get((getIndex(cs[i]) + secretKey) % 26);
        }
        return new String(cs);
    }

    private static int getIndex(char c) {
        for (int i = 0; i < ccs.size(); i++) {
            if (ccs.get(i).charValue() == c) {
                return i;
            }
        }
        return 0;
    }
}

package com.zxw.flyweight;

/**
 * @Author: Ryan
 * @Date: 2021/5/9 15:47
 * @Version: 1.0
 * @Description:
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s1);
        System.out.println(s3.intern() == s4.intern()); // intern 指的是对象所指向的常量
    }
}

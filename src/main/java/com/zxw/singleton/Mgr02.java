package com.zxw.singleton;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 15:48
 * @Version: 1.0
 * @Description: 本质和 mgr 一样
 */
public class Mgr02 {

    private static Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02() {

    }

    public static Mgr02 getInstance() {
        return INSTANCE;
    }
}

package com.zxw.singleton;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 16:12
 * @Version: 1.0
 * @Description:
 */




/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，锁住的是 Mgr04 对象，但也带来效率下降
 */
public class Mgr04 {

    private static Mgr04 INSTANCE;

    private Mgr04() {}

    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) INSTANCE = new Mgr04();
        return INSTANCE;
    }
}

package com.zxw.singleton;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 16:38
 * @Version: 1.0
 * @Description:
 */



/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Mgr06 {

    private static volatile Mgr06 INSTANCE; // JIT 指令重排的问题

    private Mgr06() {}

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr06.class) {
                // 双重检查，可以实现单例
                if (INSTANCE == null) {
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }
}

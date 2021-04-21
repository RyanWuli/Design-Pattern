package com.zxw.singleton;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 15:53
 * @Version: 1.0
 * @Description:
 */


/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题，第一个线程执行判断后还没 new 的时候，第二个线程也执行到这里的话可能两个线程都会去 new ，就没有达到单例的效果了
 */
public class Mgr03 {

    private static Mgr03 INSTANCE;

    private Mgr03() {}

    public static Mgr03 getInstance() {
        if (INSTANCE == null) INSTANCE = new Mgr03(); // 第一次调用的时候才加载
        return INSTANCE;
    }

}

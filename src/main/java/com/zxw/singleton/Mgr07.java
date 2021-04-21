package com.zxw.singleton;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 16:55
 * @Version: 1.0
 * @Description:
 */




/**
 * 静态内部类方式
 * JVM保证单例 只加载一次 类
 * 加载外部类时不会加载内部类，这样可以实现懒加载     完美
 */
public class Mgr07 {

    private Mgr07() {}

    private static class Mgr07Holder {
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.INSTANCE;
    }
}

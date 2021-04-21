package com.zxw.singleton;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 16:21
 * @Version: 1.0
 * @Description:
 */




/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Mgr05 {

    private static Mgr05 INSTANCE;

    private Mgr05() {}

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            //妄图通过减小同步代码块的方式提高效率，然后不可行，可能出现不同线程不同实例情况，原因是加锁之前可能有多个线程到达 if 判断这一步，然后等待线程结束后锁释放，等待的线程又会执行初始化操作
            synchronized (Mgr05.class) {
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }
}

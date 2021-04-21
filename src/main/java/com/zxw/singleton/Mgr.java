package com.zxw.singleton;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 15:28
 * @Version: 1.0
 * @Description: 单例模式
 */

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * Class.forName("") // 只把类 load 过来，不实例化
 * （话说你不用的，你装载它干啥）
 *
 *
 *
 *
 * 单例模式 首先是把这个 构造方法私有化
 */
public class Mgr {

    private static final Mgr INSTANCE = new Mgr();

    private Mgr() {

    }

    public static Mgr getInstance() {
        return INSTANCE;
    }

}

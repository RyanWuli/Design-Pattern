package com.zxw.singleton;

/**
 * @Author: Ryan
 * @Date: 2021/4/19 17:03
 * @Version: 1.0
 * @Description:
 */




/**
 * 不仅可以解决线程同步，还可以防止反序列化。 最完美 （防止反序列化 - 因为枚举类没有构造方法）
 */
public enum  Mgr08 {

    INSTANCE;

    public void test() {
        System.out.println("enum 单例");
    }
}

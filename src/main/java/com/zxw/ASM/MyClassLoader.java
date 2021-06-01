package com.zxw.ASM;

/**
 * @Author: Ryan
 * @Date: 2021/5/11 18:13
 * @Version: 1.0
 * @Description:
 */
public class MyClassLoader extends ClassLoader {

    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }
}

package com.zxw.templatemethod;

import com.sun.org.apache.bcel.internal.generic.POP2;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 17:05
 * @Version: 1.0
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        F f = new C();
        f.m();
    }

}

abstract class F {
    public void m() { // 这是一个模板方法，定义先执行 op1，再执行 op2，看需求制定模板
        op1();
        op2();
    }

    abstract void op1();
    abstract void op2();
}

class C extends F {

    @Override
    void op1() {
        System.out.println("--------------> op1");
    }

    @Override
    void op2() {
        System.out.println("--------------> op2");
    }
}

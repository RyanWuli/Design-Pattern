package com.zxw.state.v02;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 17:45
 * @Version: 1.0
 * @Description:
 */
public class MMNervousState extends MMState {
    @Override
    void smile() {
        System.out.println(">>>>>>>>>>>>>>>smile-nervous");
    }

    @Override
    void cry() {
        System.out.println(">>>>>>>>>>>>>>>cry-nervous");
    }

    @Override
    void say() {
        System.out.println(">>>>>>>>>>>>>>>say-nervous");
    }
}

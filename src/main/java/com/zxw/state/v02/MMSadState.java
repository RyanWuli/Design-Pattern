package com.zxw.state.v02;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 17:45
 * @Version: 1.0
 * @Description:
 */
public class MMSadState extends MMState {
    @Override
    void smile() {
        System.out.println(">>>>>>>>>>>>>>>smile-sad");
    }

    @Override
    void cry() {
        System.out.println(">>>>>>>>>>>>>>>cry-sad");
    }

    @Override
    void say() {
        System.out.println(">>>>>>>>>>>>>>>say-sad");
    }
}

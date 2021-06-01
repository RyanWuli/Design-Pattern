package com.zxw.state.v01;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 17:21
 * @Version: 1.0
 * @Description:
 */
public class MM {

    String name;
    MMState state;

    private enum MMState {HAPPY, SAD}

    public void smile() {
        // switch 根据 state 判断，然后执行笑的形式
    }

    public void cry() {
        // switch 根据 state 判断，然后执行哭的形式
    }

    public void say() {
        // switch 根据 state 判断，然后执行说的形式
    }
}

package com.zxw.state.thread;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 18:06
 * @Version: 1.0
 * @Description:
 */
public class Thread_ {

    ThreadState_ state;

    /**
     * 状态迁移
     */
    void move(Action input) {
        state.move(input);
    }

    void run() {
        state.run();
    }

}

package com.zxw.state.thread;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 18:17
 * @Version: 1.0
 * @Description:
 */
public class TerminatedState extends ThreadState_ {

    private Thread_ t;

    public TerminatedState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action action) {
        // 切换状态
    }

    @Override
    public void run() {

    }
}

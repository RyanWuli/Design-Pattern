package com.zxw.state.thread;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 18:13
 * @Version: 1.0
 * @Description:
 */
public class RunThreadState extends ThreadState_ {

    private Thread_ t;

    public RunThreadState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action action) {

    }

    @Override
    public void run() {

    }
}

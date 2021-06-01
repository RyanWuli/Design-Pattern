package com.zxw.state.thread;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 18:11
 * @Version: 1.0
 * @Description:
 */
public class NewThreadState extends ThreadState_ {

    private Thread_ t;

    public NewThreadState(Thread_ t) {
        this.t = t;
    }

    /**
     * 根据当前状态以及输入 action 来确定状态的变更
     * @param action
     */
    @Override
    public void move(Action action) {
        if ("start".equals(action.msg)) t.state = new RunThreadState(t);
    }

    @Override
    public void run() {

    }
}

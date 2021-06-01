package com.zxw.observer.v7;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/5/9 9:23
 * @Version: 1.0
 * @Description: 模拟 button 监听事件的 test
 *               总结：
 *                  1、由源对象、事件对象、和监听者组成
 *                  2、源对象中聚合监听接口（监听者）
 *                  3、独立出的事件对象，传入监听者（实现），一般都带有源对象本身
 */
public class Test {
    public static void main(String[] args) {
        Button b = new Button();
        b.addListener(new MyActionListener());
        b.addListener(new MyActionListener2());
        b.buttonPress();
    }
}

class Button {

    private List<ActionListener> listeners = new ArrayList<>();

    public void addListener(ActionListener al) {
        listeners.add(al);
    }

    public void buttonPress() {
        for (ActionListener a : listeners) {
            a.actonPerformed(new ActionEvent(System.currentTimeMillis(), this));
        }
    }
}

class ActionEvent {

    long when;
    Object source; // 事件源

    public ActionEvent(long when, Object source) {
        super();
        this.when = when;
        this.source = source;
    }
}

interface ActionListener {
    void actonPerformed(ActionEvent event);
}

class MyActionListener implements ActionListener {

    @Override
    public void actonPerformed(ActionEvent event) {
        System.out.println("button pressed!");
    }
}

class MyActionListener2 implements ActionListener {

    @Override
    public void actonPerformed(ActionEvent event) {
        System.out.println("button pressed2!");
    }
}


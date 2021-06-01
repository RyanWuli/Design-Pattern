package com.zxw.observer.v7;

import sun.awt.WindowClosingSupport;

import java.awt.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: Ryan
 * @Date: 2021/5/8 18:24
 * @Version: 1.0
 * @Description:
 */
public class TestFrame extends Frame {

    public void launch() {
        Button button = new Button("press me");
        button.addActionListener(new MyActionListener());
        button.addActionListener(new MyActionListener2());
        this.add(button);
        this.pack(); // button 包起来，button 多大 窗口就多大

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }); // 监听窗口的关闭

        this.setLocation(500, 500); // 设置位置
        this.setVisible(true); // 显示出来
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ((Button) e.getSource()).setLabel("press me again"); // 如果要使用源对象的时候使用
            System.out.println("button pressed!");
        }
    }

    private class MyActionListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed 2!");
        }
    }

    public static void main(String[] args) {
        new TestFrame().launch();
    }
}

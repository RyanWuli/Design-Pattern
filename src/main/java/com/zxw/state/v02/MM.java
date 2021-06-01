package com.zxw.state.v02;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 17:44
 * @Version: 1.0
 * @Description: 状态个数比较确定不太会变动一般才会采用这种方式
 */
public class MM {

    String name;
    MMState state;

    public MM(String name, MMState state) {
        this.name = name;
        this.state = state;
    }

    public void smile() {
        state.smile();
    }

    public void cry() {
        state.cry();
    }

    public void say() {
        state.say();
    }

    public static void main(String[] args) {
        MM mm = new MM("fbb", new MMHappyState());
        System.out.println(">>>>>>>>>>>mm 名字是：" + mm.name);
        mm.say();
    }
}

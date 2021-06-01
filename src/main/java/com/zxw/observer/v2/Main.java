package com.zxw.observer.v2;

/**
 * @Author: Ryan
 * @Date: 2021/5/8 11:52
 * @Version: 1.0
 * @Description: 面向对象观察是否哭了，本质和 v1 相同
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Child child = new Child();

        if (!child.isCry()) { // 不哭的时候
            System.out.println("Not Crying .....");
            Thread.sleep(1000);
            child.wakeup();
        }

        while (child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Observer ing .....");
        }
    }
}

class Child {

    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void wakeup() {
        System.out.println("Waked Up, wuwuwuwuwu.....");
        cry = true;
    }
}

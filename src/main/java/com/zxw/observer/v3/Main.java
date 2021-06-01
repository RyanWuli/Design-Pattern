package com.zxw.observer.v3;

/**
 * @Author: Ryan
 * @Date: 2021/5/8 11:52
 * @Version: 1.0
 * @Description: 多个观察者
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Child child = new Child();

        Dad dad = new Dad(); // 观察者
        Mom mom = new Mom(); // 观察者

        if (!child.isCry()) { // 不哭的时候
            System.out.println("Not Crying .....");
            Thread.sleep(1000);
            child.wakeup();
        }
    }
}

class Child {

    private boolean cry = false;

    private Dad dad = new Dad();

    private Mom mom = new Mom();

    public boolean isCry() {
        return cry;
    }

    public void wakeup() throws InterruptedException {
        System.out.println("Waked Up, wuwuwuwuwu.....");
        cry = true;
        dad.ready();
        mom.hug();
    }
}

class Dad {
    public void ready() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Readying Feed .....");
    }
}

class Mom {
    public void hug() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Feeding to child .....");
    }
}

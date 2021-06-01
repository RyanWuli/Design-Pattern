package com.zxw.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/5/8 11:52
 * @Version: 1.0
 * @Description: 大多数时候我们监听对象的时候需要源对象
 *               观察者只和事件打交道，不和事件源打交道，和时间源解耦合
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

    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeup() throws InterruptedException {
        System.out.println("Waked Up, wuwuwuwuwu.....");
        cry = true;
        for (Observer observer : observers) {
            observer.actionOnWakeup(new wakeupEvent(System.currentTimeMillis(), "bed", this));
        }
    }
}

interface Observer { // 观察者接口
    void actionOnWakeup(wakeupEvent event) throws InterruptedException; // 小孩醒来的观察方法
}

// 事件类
class wakeupEvent {
    long timestamp; // 时间
    String loc; // 地点
    Child source; // 源对象，也就是监听哪个对象

    public wakeupEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }
}

class Dad implements Observer {
    public void ready() {
        System.out.println("Readying Feed .....");
    }

    @Override
    public void actionOnWakeup(wakeupEvent event) throws InterruptedException {
        Thread.sleep(1000);
        if ("bed".equals(event.loc)) { // 根据事件的各种情况作出各种反应
            System.out.println("Bed Crying ..... Dad Do Sth");
        } else {
            ready();
        }
    }
}

class Mom implements Observer {
    public void hug() {
        System.out.println("Feeding to child .....");
    }

    @Override
    public void actionOnWakeup(wakeupEvent event) throws InterruptedException {
        Thread.sleep(1000);
        if ("bed".equals(event.loc)) {
            System.out.println("Bed Crying ..... Mom Do Sth");
        } else {
            hug();
        }
    }
}

class Dog implements Observer {

    @Override
    public void actionOnWakeup(wakeupEvent event) throws InterruptedException {
        Thread.sleep(1000);
        if ("bed".equals(event.loc)) {
            System.out.println("Bed Crying ..... Dog Do Sth");
        } else {
            System.out.println("Wang Wang Wang ..... ");
        }
    }
}

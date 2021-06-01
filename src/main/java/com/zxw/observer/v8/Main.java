package com.zxw.observer.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/5/9 10:17
 * @Version: 1.0
 * @Description:
 * * 有很多时候，观察者需要根据事件的具体情况来进行处理
 *  * 大多数时候，我们处理事件的时候，需要事件源对象
 *  * 事件也可以形成继承体系
 */

class Child {

    boolean cry = false;
    List<WakeupObserver> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
        observers.add((event) -> System.out.println("自定义观察处理。。。。。"));
    }

    public void wakeup() throws InterruptedException {
        System.out.println("baby wakeup, crying.....");
        cry = true;
        WakeupEvent event = new WakeupEvent(System.currentTimeMillis(), "bed", this);
        for (WakeupObserver wo : observers) {
            Thread.sleep(1000);
            wo.actionDo(event);
        }
    }
}

abstract class Event<T> {
    abstract T getSource();
}

class WakeupEvent extends Event<Child> {
    long timestamp;
    String loc;
    Child source;

    public WakeupEvent(long timestamp, String loc, Child child) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = child;
    }

    @Override
    Child getSource() {
        return source;
    }
}

interface WakeupObserver {
    void actionDo(WakeupEvent e);
}

class Dad implements WakeupObserver {
    @Override
    public void actionDo(WakeupEvent e) {
        System.out.println("dad feeding.....");
    }
}

class Mom implements WakeupObserver {
    @Override
    public void actionDo(WakeupEvent e) {
        System.out.println("mom hug.....");
    }
}

class Dog implements WakeupObserver {
    @Override
    public void actionDo(WakeupEvent e) {
        System.out.println("dog wang.....");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Child child = new Child();
        child.wakeup();
    }
}

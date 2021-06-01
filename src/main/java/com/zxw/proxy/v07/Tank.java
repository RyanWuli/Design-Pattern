package com.zxw.proxy.v07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 10:39
 * @Version: 1.0
 * @Description:
 */
public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("Tank moving claclacla.....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, (proxy, method, args1) -> {
            System.out.println("method" + method.getName() + "start .....");
            Object invoke = method.invoke(tank, args);
            System.out.println("method" + method.getName() + "end !");
            return invoke;
        });

        m.move();
    }
}

interface Movable {
    void move();
}

package com.zxw.proxy.v07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 11:54
 * @Version: 1.0
 * @Description:
 */
public class Tank2 implements Movable {

    @Override
    public void move() {
        System.out.println("Tank moving claclacla.....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * newProxyInstance 产生新的代理
     * Tank.class.getClassLoader() 需要一个 classloader 加载到内存
     * new Class[]{Movable.class} 动态代理需要实现什么接口，如果没有 jdk 的代理则实现不了代理，jdk 代理的局限
     * new LogHandler(tank) 代理自己的操作，比如记录日志，增强的部分
     * @param args
     */
    public static void main(String[] args) {
        Tank tank = new Tank();

        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new LogHandler(tank));

        m.move();
    }
}

/**
 * 把 handler 独立出来
 */
class LogHandler implements InvocationHandler {

    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    /**
     * 执行 move 方法的时候会被执行
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method" + method.getName() + "start .....");
        Object invoke = method.invoke(tank, args);
        System.out.println("method" + method.getName() + "end !");
        return invoke;
    }
}

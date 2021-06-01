package com.zxw.proxy.cglib;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2021/5/10 15:50
 * @Version: 1.0
 * @Description: cglib 的底层用的也是 asm（二进制文件修改），final 的类也能代理
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new LogInterceptor());
        Tank k = (Tank) enhancer.create();
        k.move();
    }

}

class Tank {

    public void move() {
        System.out.println("Tank moving claclacla.....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class LogInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSuperclass().getName()); // tank
        System.out.println("before.....");
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("after.....");
        return res;
    }
}

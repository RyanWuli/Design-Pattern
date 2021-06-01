package com.zxw.proxy.v08;

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

//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true"); // 保存生成的的代理文件，本来是在内容中，这样方便查看
        /*
        com/zxw/proxy/v08/$Proxy0.class 生成这个文件

        生成的代理 class 类中（内存）有个 move 方法，这个方法里会去调用 handler 中的 invoke 方法
        public final void move() throws  {
        try {
            super.h.invoke(this, m3, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); // 保存生成的的代理文件，本来是在内容中，这样方便查看

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
     * @param proxy 生成的代理对象（内存中） super.h.invoke(this, m3, (Object[])null); 中的 this ，
     *              也就是 Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new LogHandler(tank)); 中的 m
     * @param method 就是 move 方法 ；Object invoke = method.invoke(tank, args); 就是指明调用的 tank 的 move 方法
     * @param args
     * @return
     * @throws Throwable
     * getClass.getMethods() 可以获取到类下面所有的方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method" + method.getName() + "start .....");
        Object invoke = method.invoke(tank, args);
        System.out.println("method" + method.getName() + "end !");
        return invoke;
    }
}

interface Movable {
    void move();
}

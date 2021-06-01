package com.zxw.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: Ryan
 * @Date: 2021/5/9 15:31
 * @Version: 1.0
 * @Description:
 */
class Bullet {

    public UUID id = UUID.randomUUID();
    boolean living = true;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BulletPool{");
        sb.append("id=").append(id);
        sb.append(", living=").append(living);
        sb.append('}');
        return sb.toString();
    }
}

public class BulletPool {
    List<Bullet> bullets = new ArrayList<>();

    {
        for (int i = 0; i < 5; i++) bullets.add(new Bullet());
    }

    public Bullet getBullet() {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (! bullet.living) return bullet;
        }
        Bullet b = new Bullet();
        bullets.add(b);
        return b;
    }

    public static void main(String[] args) {
        BulletPool bp = new BulletPool();
        for (int i = 0; i < 10; i++) {
            Bullet b = bp.getBullet();
            System.out.println(b);
        }
    }
}


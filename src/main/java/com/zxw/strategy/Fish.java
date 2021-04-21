package com.zxw.strategy;

/**
 * @Author: Ryan
 * @Date: 2021/4/20 10:30
 * @Version: 1.0
 * @Description:
 */
public class Fish implements Comparable {

    int age;

    public Fish(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Comparable comp) {
        Fish fish = (Fish) comp;
        if (this.age < fish.age) return -1;
        else if (this.age > fish.age) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Fish{");
        sb.append("age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}

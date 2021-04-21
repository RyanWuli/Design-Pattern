package com.zxw.strategy;

/**
 * @Author: Ryan
 * @Date: 2021/4/20 10:26
 * @Version: 1.0
 * @Description:
 */
public class Dog implements Comparable {

    private int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Comparable comp) {
        Dog dog = (Dog) comp;
        if (this.food < dog.food) return -1;
        else if (this.food > dog.food) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dog{");
        sb.append("food=").append(food);
        sb.append('}');
        return sb.toString();
    }
}

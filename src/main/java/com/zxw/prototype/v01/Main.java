package com.zxw.prototype.v01;

import javax.swing.*;
import java.math.RoundingMode;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 14:56
 * @Version: 1.0
 * @Description: 浅克隆
 *               克隆必须 implement Cloneable
 *               重写 clone 方法
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person();
        Person person = (Person) p.clone();
        System.out.println("clone 后的 person:" + person);
        System.out.println("clone 前后的 location 引用是否相等：" + (p.loc == person.loc));
        System.out.println("clone 前后的 person 是否相等：" + (p == person));
        p.loc.street = "响水路";
        System.out.println("本体 loc 改了属性，clone 的 loc 属性：" + person.loc.street);
        p.age = 20;
        System.out.println("本体自身属性修改了，clone 的属性：" + person.age);
    }

}

/**
 * Cloneable 是标记型接口，需要继承才能实现 clone ，不继承编译不报错但是运行 clone 会报错
 */
class Person implements Cloneable {
    int age = 15;
    int score = 100;

    Location loc = new Location("珊瑚路", 3502);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("age=").append(age);
        sb.append(", score=").append(score);
        sb.append(", loc=").append(loc);
        sb.append('}');
        return sb.toString();
    }
}

class Location {
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Location{");
        sb.append("street='").append(street).append('\'');
        sb.append(", roomNo=").append(roomNo);
        sb.append('}');
        return sb.toString();
    }
}

package com.zxw.visitor;

import sun.security.util.ManifestEntryVerifier;

import java.nio.channels.FileChannel;

/**
 * @Author: Ryan
 * @Date: 2021/5/11 14:34
 * @Version: 1.0
 * @Description: 不同的客户组装电脑各个零部件打折不同，算总价格
 *               结构固定才适用，如果电脑部件经常增加则不适用，适用于电脑部件固定，访客不固定的这些情况
 */
public class Computer {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void computer(Visitor visitor) {
        cpu.accept(visitor);
        memory.accept(visitor);
        board.accept(visitor);
    }

    public static void main(String[] args) {
//        PersonalVisitor visitor = new PersonalVisitor();
        CompanyVisitor visitor = new CompanyVisitor();
        Computer c = new Computer();
        c.computer(visitor);
        System.out.println(visitor.totalPrice);
    }
}

abstract class ComputerPart { // 电脑部件
    abstract void accept(Visitor visitor); // 接待客户（部件对客户打折不同）
    abstract double getPrice(); // 部件价格
}

class CPU extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitorCpu(this);
    }

    @Override
    double getPrice() {
        return 2000;
    }
}

class Memory extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitorMemory(this);
    }

    @Override
    double getPrice() {
        return 600;
    }
}

class Board extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitorBoard(this);
    }

    @Override
    double getPrice() {
        return 1500;
    }
}

/**
 * 来访者，就是消费者接口，不同的消费者需要实现方法各自对不同零件的折扣算法
 */
interface Visitor {
    void visitorCpu(CPU cpu);
    void visitorMemory(Memory memory);
    void visitorBoard(Board board);
}

/**
 * 具体某类消费者
 */
class PersonalVisitor implements Visitor {

    double totalPrice = 0.0;

    @Override
    public void visitorCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    public void visitorMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.85;
    }

    @Override
    public void visitorBoard(Board board) {
        totalPrice += board.getPrice() * 0.95;
    }
}

class CompanyVisitor implements Visitor {

    double totalPrice = 0.0;

    @Override
    public void visitorCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.7;
    }

    @Override
    public void visitorMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.6;
    }

    @Override
    public void visitorBoard(Board board) {
        totalPrice += board.getPrice() * 0.75;
    }
}
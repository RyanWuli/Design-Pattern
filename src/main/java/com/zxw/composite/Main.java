package com.zxw.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/5/9 14:36
 * @Version: 1.0
 * @Description: 组合模式 节点
 */
public class Main {

    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        LeafNode r_content = new LeafNode("r_content");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        BranchNode section1 = new BranchNode("section1");
        BranchNode section2 = new BranchNode("section2");
        LeafNode content1 = new LeafNode("content1");
        LeafNode content2 = new LeafNode("content2");
        LeafNode content3 = new LeafNode("content3");

        root.add(chapter1);
        root.add(chapter2);
        root.add(r_content);
        chapter1.add(content1);
        chapter2.add(section1);
        chapter2.add(section2);
        chapter2.add(content2);
        section2.add(content3);

        tree(root);

        System.out.println("*********************************************************");

        treeStructure(root, 0);
    }

    static void tree(Node node) { // 递归直接打印
        node.print();

        if (node instanceof BranchNode) {
            for (Node n : ((BranchNode) node).nodes) {
                tree(n);
            }
        }

    }

    static void treeStructure(Node node, int depth) { // 递归利用深度打出结构
        for (int i = 0; i < depth; i++) System.out.print("--");
        node.print();

        if (node instanceof BranchNode) {
            for (Node n : ((BranchNode) node).nodes) {
                treeStructure(n, depth + 1);
            }
        }

    }

}

abstract class Node {
    abstract void print();
}

class BranchNode extends Node {

    String name;

    List<Node> nodes = new ArrayList<>();

    @Override
    void print() {
        System.out.println(name);
    }

    public BranchNode(String name) {
        this.name = name;
    }

    public void add(Node node) {
        nodes.add(node);
    }
}

class LeafNode extends Node {

    String content;

    @Override
    void print() {
        System.out.println(content);
    }

    public LeafNode(String content) {
        this.content = content;
    }
}

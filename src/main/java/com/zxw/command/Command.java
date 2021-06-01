package com.zxw.command;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 11:35
 * @Version: 1.0
 * @Description: command 封装命令（比如编辑器菜单命令这些）
 */
public abstract class Command {

    public abstract void todo(); // exec run
    public abstract void undo();
}

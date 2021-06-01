package com.zxw.command.V02;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 11:43
 * @Version: 1.0
 * @Description:
 */
public class CopyCommand extends Command {

//    Content c;
    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    public void todo() {
        c.msg += c.msg;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() / 2);
    }
}

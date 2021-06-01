package com.zxw.command;

import java.net.ConnectException;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 11:45
 * @Version: 1.0
 * @Description:
 */
public class DeleteCommand extends Command {

    Content c;
    String delete;

    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void todo() {
        delete = c.msg.substring(0, 5);
        c.msg = c.msg.substring(5);
    }

    @Override
    public void undo() {
        c.msg = delete + c.msg;
    }
}

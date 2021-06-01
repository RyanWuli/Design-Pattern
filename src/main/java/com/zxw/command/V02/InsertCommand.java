package com.zxw.command.V02;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 11:38
 * @Version: 1.0
 * @Description:
 */
public class InsertCommand extends Command {

//    Content c;
    String strToInsert = "https://baidu.com";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void todo() {
        c.msg += strToInsert;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() - strToInsert.length());
    }
}

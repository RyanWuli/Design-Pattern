package com.zxw.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/5/13 11:49
 * @Version: 1.0
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Content c = new Content();
        Command insertCommand = new InsertCommand(c);
        Command deleteCommand = new DeleteCommand(c);
        Command copyCommand = new CopyCommand(c);

        insertCommand.todo();
        System.out.println(">>>>>>>>>>>>>>> 插入操作 todo 后：" + c.msg);
        insertCommand.undo();
        System.out.println(">>>>>>>>>>>>>>> 插入操作 undo 后：" + c.msg);

        deleteCommand.todo();
        System.out.println(">>>>>>>>>>>>>>> 删除操作 todo 后：" + c.msg);
        deleteCommand.undo();
        System.out.println(">>>>>>>>>>>>>>> 删除操作 undo 后：" + c.msg);

        copyCommand.todo();
        System.out.println(">>>>>>>>>>>>>>> 复制操作 todo 后：" + c.msg);
        copyCommand.undo();
        System.out.println(">>>>>>>>>>>>>>> 复制操作 undo 后：" + c.msg);

    }
}

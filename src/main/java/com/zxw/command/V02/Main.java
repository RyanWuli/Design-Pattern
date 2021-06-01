package com.zxw.command.V02;

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

        System.out.println("-----------------------------------------------------cor");

        List<Command> commands = new ArrayList<>();
        commands.add(new InsertCommand(c));
        commands.add(new DeleteCommand(c));
        commands.add(new CopyCommand(c));

        // to do()
        for (int i = 0; i < commands.size(); i++) {
            Command command = commands.get(i);
            command.todo();
            System.out.println(">>>>>>>>>>>>>> todo:" + command.c.msg);
        }

        for (int j = commands.size() - 1; j >= 0; j--) {
            Command command = commands.get(j);
            command.undo();
            System.out.println(">>>>>>>>>>>>>>> undo:" + command.c.msg);
        }
    }
}

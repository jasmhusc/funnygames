package kcb;

import javax.swing.*;
/*
MVC设计模式：
* Jtable--数据表现View和控制Control在一起实现，因为用户是通过在View上进行操作来控制的数据的。
* TableModel--数据存储，更新和管理。
* */
public class KCB {
    public static void main(String[] args) {
        JFrame frame = new JFrame("课程表");
        JScrollPane Pane = new JScrollPane(new KCBView(new KCBData()));
        frame.add(Pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400,400);
        frame.pack();
        frame.setVisible(true);
    }
}

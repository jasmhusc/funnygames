package kcb;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class KCBView extends JTable{
    public KCBView(KCBData kcbData){
        super(kcbData);
        setFont(new Font("楷体",Font.PLAIN,18));
        // 设置行高和行宽
        setRowHeight(24);
        setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        for (int i = 0; i < 7; i++) {
            TableColumn column = getColumnModel().getColumn(i);
                column.setPreferredWidth(50);
        }
        // 设置表格隔行换色
    }
}

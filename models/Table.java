package models;

import javax.swing.*;
import java.awt.*;

public class Table extends JTable {
    private JTable table = new JTable();
    public Table() {
        table.setShowGrid(false);
        table.setShowVerticalLines(false);
        table.setBorder(null);
        table.setRowHeight(50);
        table.getTableHeader().setBackground(new Constants().getSecondaryColor());
        table.getTableHeader().setBorder(null);
        table.getTableHeader().setPreferredSize(new Dimension(40,40));
        table.getTableHeader().setForeground(new Constants().getPrimaryColor());
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream("../Assets/Fonts/VarelaRound-Regular.TTF"));
            table.setFont(font.deriveFont(Font.PLAIN, 12f));
            table.getTableHeader().setFont(font.deriveFont(Font.PLAIN, 13f));
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    public JTable getTable() {
        return table;
    }
}

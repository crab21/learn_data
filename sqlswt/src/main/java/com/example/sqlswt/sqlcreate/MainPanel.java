package com.example.sqlswt.sqlcreate;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @program: sqlAwt
 * @description:
 * @author: Mr.Wang
 * @create: 2018-11-02 16:32
 **/
public class MainPanel {


    public static void create() {
        JFrame jFrame = new JFrame("sql");


        JPanel panel = new JPanel();
        //todo

//        button.setVisible(false);

        List<String> tableNames = SqlFind.getTableNames();
        String[] result = tableNames.toArray(new String[tableNames.size()]);
        JList<String> stringJList = new JList<>();
        stringJList.setListData(result);
        stringJList.setBounds(100, 200, 300, 6000);
        stringJList.setSelectedIndex(0);
        stringJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // 获取所有被选中的选项索引
                int[] indices = stringJList.getSelectedIndices();
                // 获取选项数据的 ListModel
                ListModel<String> listModel = stringJList.getModel();
                // 输出选中的选项
                for (int index : indices) {
                    System.out.println("选中: " + index + " = " + listModel.getElementAt(index));
                }
            }
        });
        stringJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        JScrollPane jsp = new JScrollPane(stringJList);
        jsp.setBounds(800, 800, 420, 2200);//指定了JScrollPane的大小和位置
        jsp.setPreferredSize(new Dimension(200, 400));


        JButton button = new JButton("导出数据列表");
        button.setBounds(100, 200, 30, 90);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取所有被选中的选项索引
                int[] indices = stringJList.getSelectedIndices();
                // 获取选项数据的 ListModel
                ListModel<String> listModel = stringJList.getModel();
                // 输出选中的选项
                for (int index : indices) {
//                    System.out.println("选中: " + index + " = " + listModel.getElementAt(index));
                    String tableName = listModel.getElementAt(index);
                    TablePanelDeal.reduceTable(tableName);
                }
            }
        });

        // todo 面板添加信息
        panel.add(button);
        panel.add(jsp);


        //添加看板
        jFrame.add(panel);
        jFrame.setVisible(true);
        jFrame.setSize(500, 500);
//        jFrame.setLocation(500,500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int[] indices = stringJList.getSelectedIndices();

    }

    public static void main(String[] args) {
        create();
    }
}

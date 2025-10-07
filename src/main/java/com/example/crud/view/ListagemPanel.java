package com.example.crud.view;

import javax.swing.*;
import java.awt.*;

public class ListagemPanel extends JPanel {
    private JTable table;
    private ProdutoTableModel tableModel;

    public ListagemPanel() {
        setLayout(new BorderLayout());

        tableModel = new ProdutoTableModel();
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public ProdutoTableModel getTableModel() {
        return tableModel;
    }
}

package com.example.crud.view;

import com.example.crud.model.Produto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProdutoTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "Nome", "Preço"};
    private List<Produto> produtos;

    public ProdutoTableModel() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return produto.getId();
            case 1:
                return produto.getNome();
            case 2:
                return produto.getPreco();
            default:
                return null;
        }
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        fireTableDataChanged(); // Notifica a JTable que os dados mudaram
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1); // Notifica a JTable sobre a nova linha
    }
}

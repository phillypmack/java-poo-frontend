package com.example.crud.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoView extends JFrame {

    private JTextField nomeField, referenciaField, fornecedorField, categoriaField, marcaField;
    private JButton salvarButton, limparButton, deletarButton;
    private JTable tabelaProdutos;
    private DefaultTableModel tableModel;

    public ProdutoView() {
        setTitle("Cadastro e Consulta de Produtos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de cadastro
        JPanel painelCadastro = new JPanel(new GridLayout(6, 2));
        painelCadastro.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        painelCadastro.add(nomeField);

        painelCadastro.add(new JLabel("Referência:"));
        referenciaField = new JTextField();
        painelCadastro.add(referenciaField);

        painelCadastro.add(new JLabel("Fornecedor:"));
        fornecedorField = new JTextField();
        painelCadastro.add(fornecedorField);

        painelCadastro.add(new JLabel("Categoria:"));
        categoriaField = new JTextField();
        painelCadastro.add(categoriaField);

        painelCadastro.add(new JLabel("Marca:"));
        marcaField = new JTextField();
        painelCadastro.add(marcaField);

        salvarButton = new JButton("Salvar");
        limparButton = new JButton("Limpar");
        painelCadastro.add(salvarButton);
        painelCadastro.add(limparButton);

        // Painel de consulta
        JPanel painelConsulta = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new Object[]{"Nome", "Referência", "Fornecedor", "Categoria", "Marca"}, 0);
        tabelaProdutos = new JTable(tableModel);
        painelConsulta.add(new JScrollPane(tabelaProdutos), BorderLayout.CENTER);

        JPanel painelBotoesConsulta = new JPanel();
        deletarButton = new JButton("Deletar");
        painelBotoesConsulta.add(deletarButton);
        painelConsulta.add(painelBotoesConsulta, BorderLayout.SOUTH);

        // Adicionando painéis à janela
        add(painelCadastro, BorderLayout.NORTH);
        add(painelConsulta, BorderLayout.CENTER);

        // Ações dos botões
        salvarButton.addActionListener(e -> salvarProduto());
        limparButton.addActionListener(e -> limparCampos());
        deletarButton.addActionListener(e -> deletarProduto());

        // Mock de dados
        mockDados();
    }

    private void salvarProduto() {
        String nome = nomeField.getText();
        String referencia = referenciaField.getText();
        String fornecedor = fornecedorField.getText();
        String categoria = categoriaField.getText();
        String marca = marcaField.getText();

        if (nome.isEmpty() || referencia.isEmpty() || fornecedor.isEmpty() || categoria.isEmpty() || marca.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{nome, referencia, fornecedor, categoria, marca});
        limparCampos();
    }

    private void limparCampos() {
        nomeField.setText("");
        referenciaField.setText("");
        fornecedorField.setText("");
        categoriaField.setText("");
        marcaField.setText("");
    }

    private void deletarProduto() {
        int selectedRow = tabelaProdutos.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para deletar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mockDados() {
        tableModel.addRow(new Object[]{"Gasolina Comum", "GC001", "Petrobras", "Combustível", "Petrobras"});
        tableModel.addRow(new Object[]{"Óleo Motor 15W40", "OM1540", "Ipiranga", "Lubrificante", "Ipiranga"});
    }
}

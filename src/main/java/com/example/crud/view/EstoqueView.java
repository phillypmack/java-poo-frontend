package com.example.crud.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EstoqueView extends JFrame {

    private JComboBox<String> produtoComboBox;
    private JTextField quantidadeField, dataValidadeField, localTanqueField, localEnderecoField, loteFabricacaoField;
    private JButton salvarButton, limparButton, deletarButton;
    private JTable tabelaEstoque;
    private DefaultTableModel tableModel;

    public EstoqueView() {
        setTitle("Cadastro e Consulta de Estoque");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de cadastro
        JPanel painelCadastro = new JPanel(new GridLayout(7, 2));

        painelCadastro.add(new JLabel("Produto:"));
        produtoComboBox = new JComboBox<>(new String[]{"Gasolina Comum", "Óleo Motor 15W40"});
        painelCadastro.add(produtoComboBox);

        painelCadastro.add(new JLabel("Quantidade:"));
        quantidadeField = new JTextField();
        painelCadastro.add(quantidadeField);

        painelCadastro.add(new JLabel("Data de Validade (yyyy-mm-dd):"));
        dataValidadeField = new JTextField();
        painelCadastro.add(dataValidadeField);

        painelCadastro.add(new JLabel("Local do Tanque:"));
        localTanqueField = new JTextField();
        painelCadastro.add(localTanqueField);

        painelCadastro.add(new JLabel("Endereço do Local:"));
        localEnderecoField = new JTextField();
        painelCadastro.add(localEnderecoField);

        painelCadastro.add(new JLabel("Lote de Fabricação:"));
        loteFabricacaoField = new JTextField();
        painelCadastro.add(loteFabricacaoField);

        salvarButton = new JButton("Salvar");
        limparButton = new JButton("Limpar");
        painelCadastro.add(salvarButton);
        painelCadastro.add(limparButton);

        // Painel de consulta
        JPanel painelConsulta = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new Object[]{"Produto", "Quantidade", "Validade", "Tanque", "Endereço", "Lote"}, 0);
        tabelaEstoque = new JTable(tableModel);
        painelConsulta.add(new JScrollPane(tabelaEstoque), BorderLayout.CENTER);

        JPanel painelBotoesConsulta = new JPanel();
        deletarButton = new JButton("Deletar");
        painelBotoesConsulta.add(deletarButton);
        painelConsulta.add(painelBotoesConsulta, BorderLayout.SOUTH);

        // Adicionando painéis à janela
        add(painelCadastro, BorderLayout.NORTH);
        add(painelConsulta, BorderLayout.CENTER);

        // Ações dos botões
        salvarButton.addActionListener(e -> salvarEstoque());
        limparButton.addActionListener(e -> limparCampos());
        deletarButton.addActionListener(e -> deletarEstoque());

        // Mock de dados
        mockDados();
    }

    private void salvarEstoque() {
        String produto = (String) produtoComboBox.getSelectedItem();
        String quantidade = quantidadeField.getText();
        String dataValidade = dataValidadeField.getText();
        String localTanque = localTanqueField.getText();
        String localEndereco = localEnderecoField.getText();
        String loteFabricacao = loteFabricacaoField.getText();

        if (quantidade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Quantidade é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{produto, quantidade, dataValidade, localTanque, localEndereco, loteFabricacao});
        limparCampos();
    }

    private void limparCampos() {
        produtoComboBox.setSelectedIndex(0);
        quantidadeField.setText("");
        dataValidadeField.setText("");
        localTanqueField.setText("");
        localEnderecoField.setText("");
        loteFabricacaoField.setText("");
    }

    private void deletarEstoque() {
        int selectedRow = tabelaEstoque.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item do estoque para deletar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mockDados() {
        tableModel.addRow(new Object[]{"Gasolina Comum", "10000.000", "2024-12-31", "T-01", "Pátio Principal", "LOTE-GC-202310"});
        tableModel.addRow(new Object[]{"Óleo Motor 15W40", "500.000", "2025-08-15", "Prateleira A-5", "Depósito 2", "LOTE-OM-202309"});
    }
}

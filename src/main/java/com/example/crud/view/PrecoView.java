package com.example.crud.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrecoView extends JFrame {

    private JComboBox<String> produtoComboBox;
    private JTextField valorField;
    private JButton salvarButton, limparButton, deletarButton;
    private JTable tabelaPrecos;
    private DefaultTableModel tableModel;

    public PrecoView() {
        setTitle("Cadastro e Consulta de Preços");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de cadastro
        JPanel painelCadastro = new JPanel(new GridLayout(4, 2));

        painelCadastro.add(new JLabel("Produto:"));
        // Mock de produtos. Em uma aplicação real, viria do banco de dados.
        produtoComboBox = new JComboBox<>(new String[]{"Gasolina Comum", "Óleo Motor 15W40"});
        painelCadastro.add(produtoComboBox);

        painelCadastro.add(new JLabel("Valor:"));
        valorField = new JTextField();
        painelCadastro.add(valorField);

        salvarButton = new JButton("Salvar");
        limparButton = new JButton("Limpar");
        painelCadastro.add(salvarButton);
        painelCadastro.add(limparButton);

        // Painel de consulta
        JPanel painelConsulta = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new Object[]{"Produto", "Valor", "Data Alteração"}, 0);
        tabelaPrecos = new JTable(tableModel);
        painelConsulta.add(new JScrollPane(tabelaPrecos), BorderLayout.CENTER);

        JPanel painelBotoesConsulta = new JPanel();
        deletarButton = new JButton("Deletar");
        painelBotoesConsulta.add(deletarButton);
        painelConsulta.add(painelBotoesConsulta, BorderLayout.SOUTH);

        // Adicionando painéis à janela
        add(painelCadastro, BorderLayout.NORTH);
        add(painelConsulta, BorderLayout.CENTER);

        // Ações dos botões
        salvarButton.addActionListener(e -> salvarPreco());
        limparButton.addActionListener(e -> limparCampos());
        deletarButton.addActionListener(e -> deletarPreco());

        // Mock de dados
        mockDados();
    }

    private void salvarPreco() {
        String produto = (String) produtoComboBox.getSelectedItem();
        String valor = valorField.getText();
        String dataAlteracao = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Valor é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{produto, valor, dataAlteracao});
        limparCampos();
    }

    private void limparCampos() {
        produtoComboBox.setSelectedIndex(0);
        valorField.setText("");
    }

    private void deletarPreco() {
        int selectedRow = tabelaPrecos.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um preço para deletar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mockDados() {
        tableModel.addRow(new Object[]{"Gasolina Comum", "5.89", "2023-10-27 10:00:00"});
        tableModel.addRow(new Object[]{"Óleo Motor 15W40", "35.50", "2023-10-27 10:05:00"});
    }
}

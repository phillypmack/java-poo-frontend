package com.example.crud.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PessoaView extends JFrame {

    private JTextField nomeCompletoField, cpfCnpjField, numeroCtpsField, dataNascimentoField;
    private JComboBox<String> tipoPessoaComboBox;
    private JButton salvarButton, limparButton, deletarButton;
    private JTable tabelaPessoas;
    private DefaultTableModel tableModel;

    public PessoaView() {
        setTitle("Cadastro e Consulta de Pessoas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de cadastro
        JPanel painelCadastro = new JPanel(new GridLayout(6, 2));

        painelCadastro.add(new JLabel("Nome Completo:"));
        nomeCompletoField = new JTextField();
        painelCadastro.add(nomeCompletoField);

        painelCadastro.add(new JLabel("CPF/CNPJ:"));
        cpfCnpjField = new JTextField();
        painelCadastro.add(cpfCnpjField);

        painelCadastro.add(new JLabel("Nº CTPS:"));
        numeroCtpsField = new JTextField();
        painelCadastro.add(numeroCtpsField);

        painelCadastro.add(new JLabel("Data Nascimento (yyyy-mm-dd):"));
        dataNascimentoField = new JTextField();
        painelCadastro.add(dataNascimentoField);

        painelCadastro.add(new JLabel("Tipo Pessoa:"));
        tipoPessoaComboBox = new JComboBox<>(new String[]{"FISICA", "JURIDICA"});
        painelCadastro.add(tipoPessoaComboBox);

        salvarButton = new JButton("Salvar");
        limparButton = new JButton("Limpar");
        painelCadastro.add(salvarButton);
        painelCadastro.add(limparButton);

        // Painel de consulta
        JPanel painelConsulta = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new Object[]{"Nome Completo", "CPF/CNPJ", "Nº CTPS", "Data Nascimento", "Tipo Pessoa"}, 0);
        tabelaPessoas = new JTable(tableModel);
        painelConsulta.add(new JScrollPane(tabelaPessoas), BorderLayout.CENTER);

        JPanel painelBotoesConsulta = new JPanel();
        deletarButton = new JButton("Deletar");
        painelBotoesConsulta.add(deletarButton);
        painelConsulta.add(painelBotoesConsulta, BorderLayout.SOUTH);

        // Adicionando painéis à janela
        add(painelCadastro, BorderLayout.NORTH);
        add(painelConsulta, BorderLayout.CENTER);

        // Ações dos botões
        salvarButton.addActionListener(e -> salvarPessoa());
        limparButton.addActionListener(e -> limparCampos());
        deletarButton.addActionListener(e -> deletarPessoa());

        // Mock de dados
        mockDados();
    }

    private void salvarPessoa() {
        String nomeCompleto = nomeCompletoField.getText();
        String cpfCnpj = cpfCnpjField.getText();
        String numeroCtps = numeroCtpsField.getText(); // Opcional
        String dataNascimento = dataNascimentoField.getText();
        String tipoPessoa = (String) tipoPessoaComboBox.getSelectedItem();

        if (nomeCompleto.isEmpty() || cpfCnpj.isEmpty() || dataNascimento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome, CPF/CNPJ e Data de Nascimento são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{nomeCompleto, cpfCnpj, numeroCtps, dataNascimento, tipoPessoa});
        limparCampos();
    }

    private void limparCampos() {
        nomeCompletoField.setText("");
        cpfCnpjField.setText("");
        numeroCtpsField.setText("");
        dataNascimentoField.setText("");
        tipoPessoaComboBox.setSelectedIndex(0);
    }

    private void deletarPessoa() {
        int selectedRow = tabelaPessoas.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa para deletar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mockDados() {
        tableModel.addRow(new Object[]{"João da Silva", "111.111.111-11", "12345", "1990-01-15", "FISICA"});
        tableModel.addRow(new Object[]{"Empresa Exemplo LTDA", "11.222.333/0001-44", "", "2010-05-20", "JURIDICA"});
    }
}

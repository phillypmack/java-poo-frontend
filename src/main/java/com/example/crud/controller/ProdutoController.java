package com.example.crud.controller;

import com.example.crud.model.Produto;
import com.example.crud.view.CadastroPanel;
import com.example.crud.view.ListagemPanel;
import com.example.crud.view.ProdutoTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private CadastroPanel cadastroPanel;
    private ListagemPanel listagemPanel;
    private ProdutoTableModel tableModel;
    private List<Produto> produtos; // Nossa "base de dados" em memória
    private int proximoId = 1;

    public ProdutoController(CadastroPanel cadastroPanel, ListagemPanel listagemPanel) {
        this.cadastroPanel = cadastroPanel;
        this.listagemPanel = listagemPanel;
        this.tableModel = listagemPanel.getTableModel();
        this.produtos = new ArrayList<>();

        // Adiciona o listener para o botão Salvar
        this.cadastroPanel.getSalvarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarProduto();
            }
        });
    }

    private void salvarProduto() {
        String nome = cadastroPanel.getNomeField().getText();
        String precoStr = cadastroPanel.getPrecoField().getText();

        if (nome.isEmpty() || precoStr.isEmpty()) {
            JOptionPane.showMessageDialog(cadastroPanel, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double preco = Double.parseDouble(precoStr);
            Produto produto = new Produto(proximoId++, nome, preco);

            // Adiciona na lista em memória e no modelo da tabela
            produtos.add(produto);
            tableModel.addProduto(produto);

            // Limpa os campos do formulário
            cadastroPanel.getNomeField().setText("");
            cadastroPanel.getPrecoField().setText("");

            JOptionPane.showMessageDialog(cadastroPanel, "Produto salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(cadastroPanel, "O preço deve ser um número válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}

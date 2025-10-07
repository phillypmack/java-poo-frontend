package com.example.crud.view;

import com.example.crud.controller.ProdutoController;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Aplicação CRUD com Swing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Cria os painéis (Views)
        CadastroPanel cadastroPanel = new CadastroPanel();
        ListagemPanel listagemPanel = new ListagemPanel();

        // Cria o Controller e conecta-o às Views
        new ProdutoController(cadastroPanel, listagemPanel);

        tabbedPane.addTab("Cadastro", cadastroPanel);
        tabbedPane.addTab("Listagem", listagemPanel);

        add(tabbedPane);
    }
}

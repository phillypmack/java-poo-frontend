package com.example.crud.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("PDV - Ponto de Venda");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu cadastrosMenu = new JMenu("Cadastros");
        menuBar.add(cadastrosMenu);

        JMenuItem pessoasMenuItem = new JMenuItem("Pessoas");
        pessoasMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PessoaView pessoaView = new PessoaView();
                pessoaView.setVisible(true);
            }
        });
        cadastrosMenu.add(pessoasMenuItem);

        JMenuItem produtosMenuItem = new JMenuItem("Produtos");
        produtosMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProdutoView produtoView = new ProdutoView();
                produtoView.setVisible(true);
            }
        });
        cadastrosMenu.add(produtosMenuItem);

        setJMenuBar(menuBar);
    }
}

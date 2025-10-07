package com.example.crud.view;

import javax.swing.*;
import java.awt.*;

public class CadastroPanel extends JPanel {
    private JTextField nomeField;
    private JTextField precoField;
    private JButton salvarButton;

    public CadastroPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Rótulo e campo para Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Faz o campo de texto expandir horizontalmente
        nomeField = new JTextField(20);
        add(nomeField, gbc);

        // Rótulo e campo para Preço
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        add(new JLabel("Preço:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        precoField = new JTextField(20);
        add(precoField, gbc);

        // Botão Salvar
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupa duas colunas
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        salvarButton = new JButton("Salvar");
        add(salvarButton, gbc);
    }

    // Getters para os componentes, para que o Controller possa acessá-los
    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getPrecoField() {
        return precoField;
    }

    public JButton getSalvarButton() {
        return salvarButton;
    }
}

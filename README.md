# Aplicação CRUD com Java Swing

Este projeto é uma aplicação desktop desenvolvida em Java com a biblioteca Swing para a interface gráfica. O objetivo é demonstrar um exemplo prático de operações CRUD (Create, Read, Update, Delete) seguindo os princípios da Programação Orientada a Objetos.

## 🚀 Estrutura do Projeto

O código-fonte está organizado em pacotes para separar as responsabilidades, seguindo uma abordagem inspirada no padrão MVC (Model-View-Controller):

- `com.example.crud`: Pacote raiz da aplicação.
  - `Main.java`: Ponto de entrada da aplicação que inicializa a interface gráfica.
- `com.example.crud.view`: Contém todas as classes relacionadas à interface gráfica (GUI).
  - `MainFrame.java`: A janela principal da aplicação, que contém a estrutura de abas.
  - `CadastroPanel.java`: O painel com o formulário para cadastrar novos itens.
  - `ListagemPanel.java`: O painel que exibirá os itens cadastrados em uma tabela.
- `com.example.crud.model`: (Futuro) Contém as classes de modelo de dados (ex: `Produto.java`).
- `com.example.crud.controller`: (Futuro) Contém as classes que fazem a mediação entre a View e o Model.

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Swing**: Biblioteca para criação de interfaces gráficas em Java.
- **Maven**: Ferramenta para gerenciamento de dependências e build do projeto.

## 📋 Próximos Passos

- [ ] Definir a classe de modelo `Produto`.
- [ ] Implementar o formulário de cadastro no `CadastroPanel`.
- [ ] Implementar a tabela de exibição de dados no `ListagemPanel`.
- [ ] Adicionar a lógica para salvar (em memória) e listar os produtos.
- [ ] Implementar as funcionalidades de atualização (Update) e exclusão (Delete).

## Como Executar

Após clonar o projeto, você pode abri-lo em sua IDE de preferência (como IntelliJ IDEA ou Eclipse) e executar a classe `Main.java`.

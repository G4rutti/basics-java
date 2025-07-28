# Sistema de Gerenciamento de Biblioteca com Banco de Dados 📚

Este projeto é uma evolução de um sistema de console em Java, agora utilizando **JDBC** para persistir os dados em um banco de dados **MySQL**. O objetivo é demonstrar a integração de uma aplicação Java com um banco de dados relacional e introduzir a separação de responsabilidades através do padrão de projeto **DAO (Data Access Object)**.

O sistema simula as operações básicas de uma biblioteca, garantindo que todas as informações sobre os livros sejam salvas permanentemente.

## ✨ Funcionalidades

* **Persistência de Dados:** Todas as informações são salvas em um banco de dados MySQL, garantindo que os dados não sejam perdidos ao fechar a aplicação.
* **Adicionar Livros:** Cadastra novos livros diretamente no banco de dados.
* **Listar Livros:** Exibe todos os livros consultando o banco de dados em tempo real.
* **Emprestar e Devolver Livros:** Altera o status de disponibilidade de um livro, atualizando o registro correspondente no banco.
* **Menu Interativo:** O sistema continua a ser operado através de um menu de console simples e intuitivo.

## 🚀 Tecnologias e Conceitos Aplicados

* **Java**: Linguagem principal do projeto.
* **JDBC (Java Database Connectivity)**: API padrão do Java para conexão com bancos de dados.
* **MySQL**: Sistema de Gerenciamento de Banco de Dados Relacional utilizado para armazenar os dados.
* **Padrão de Projeto DAO (Data Access Object)**: Utilizado para separar a lógica de acesso a dados da lógica de negócios da aplicação.

## ⚙️ Pré-requisitos e Configuração

Para executar este projeto, você precisará ter o seguinte ambiente configurado:

1.  **JDK (Java Development Kit)**: Versão 8 ou superior.
2.  **MySQL Server**: O servidor de banco de dados onde os dados serão armazenados.
3.  **MySQL Connector/J**: O driver JDBC para MySQL. Você pode baixá-lo [aqui](https://dev.mysql.com/downloads/connector/j/) e precisa adicioná-lo ao classpath do seu projeto.

## 🛠️ Como Executar o Projeto

#### 1. Clone o Repositório
```bash
git clone https://github.com/G4rutti/basics-java/tree/main/src/BibliotecaComJDBC
cd BibliotecaComJDBC

-- Cria o banco de dados (se ainda não existir)
CREATE DATABASE IF NOT EXISTS library;

-- Seleciona o banco de dados para usar
USE library;

-- Cria a tabela para armazenar os livros
CREATE TABLE IF NOT EXISTS Livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomeLivro VARCHAR(255) NOT NULL,
    autorLivro VARCHAR(255) NOT NULL,
    anoPostagem INT,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

-- Em src/BibliotecaComJDBC/Database.java
String url = "jdbc:mysql://127.0.0.1:3306/library"; // Mantenha se o MySQL estiver local na porta padrão
String user = "root"; // Altere para o seu usuário do MySQL
String password = "admin"; // Altere para a sua senha

javac -cp "caminho/para/mysql-connector-j-8.x.x.jar" src/BibliotecaComJDBC/*.java

# Para Windows
java -cp "src;caminho/para/mysql-connector-j-8.x.x.jar" BibliotecaComJDBC.SistemaBiblioteca

# Para Linux/macOS
java -cp "src:caminho/para/mysql-connector-j-8.x.x.jar" BibliotecaComJDBC.SistemaBiblioteca

📂 Estrutura do Projeto
/
|-- src/
|   |-- BibliotecaComJDBC/
|       |-- Database.java          # Gerencia a conexão com o banco de dados.
|       |-- Livro.java             # Objeto de modelo (POJO) que representa um livro.
|       |-- LivroDAO.java          # Objeto de Acesso a Dados, responsável por toda a comunicação com a tabela Livro.
|       |-- Biblioteca.java        # Classe de serviço que orquestra as operações.
|       |-- SistemaBiblioteca.java # Classe principal com o método main e o menu interativo.
|-- .gitignore
|-- README.md

Este é um projeto de console simples, desenvolvido em Java, com o objetivo de aplicar e solidificar os conceitos fundamentais da Programação Orientada a Objetos (POO). O sistema simula as operações básicas de uma biblioteca, como adicionar, listar e gerenciar o empréstimo e a devolução de livros.

Este projeto foi criado como um exercício prático de aprendizado, focado na clareza do código e na aplicação de boas práticas de POO.

## ✨ Funcionalidades

* **Adicionar Livros:** Permite ao usuário cadastrar novos livros no acervo, informando título, autor e ano de publicação.
* **Listar Livros:** Exibe todos os livros cadastrados, mostrando suas informações completas e seu status atual (Disponível ou Emprestado).
* **Emprestar Livros:** Permite que um livro disponível seja marcado como "Emprestado".
* **Devolver Livros:** Permite que um livro emprestado seja marcado como "Disponível".
* **Busca Flexível:** A busca por livros para empréstimo ou devolução não diferencia letras maiúsculas de minúsculas.
* **Menu Interativo:** O sistema é operado através de um menu de console simples e intuitivo.

## 🚀 Tecnologias Utilizadas

* **Java**: Linguagem principal do projeto.
* **JDK (Java Development Kit)**: Necessário para compilar e executar o código.

## 🧠 Conceitos de POO Aplicados

Este projeto foi uma oportunidade para praticar os pilares da Programação Orientada a Objetos:

* **Classes e Objetos:** Modelagem do mundo real através das classes `Livro` (representando um objeto livro) e `Biblioteca` (representando o acervo).
* **Encapsulamento:** Proteção dos atributos das classes (ex: `titulo`, `acervo`) como `private`, expondo o acesso controlado através de métodos públicos (`getters`, `emprestar()`, etc.).
* **Abstração:** A classe `SistemaBiblioteca` interage com um objeto `Biblioteca` de forma simples (`adicionarLivro()`, `listarLivros()`), sem precisar conhecer os detalhes complexos de como a lista de livros (`ArrayList`) é gerenciada internamente.
* **Composição:** A classe `Biblioteca` *tem uma* coleção de objetos `Livro`, demonstrando a relação de composição entre objetos.

## ⚙️ Como Executar o Projeto

Para executar este projeto em sua máquina local, siga os passos abaixo.

**Pré-requisitos:**
* Ter o [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) instalado.

**Passos:**

1.  **Clone o repositório:**
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd nome-do-repositorio
    ```

3.  **Compile os arquivos Java:**
    (Assumindo que seus arquivos `.java` estão dentro de uma pasta `src/Biblioteca`)
    ```bash
    javac src/Biblioteca/*.java
    ```

4.  **Execute a classe principal:**
    ```bash
    java -cp src Biblioteca.SistemaBiblioteca
    ```
    O menu interativo da biblioteca será exibido no seu console.

## 📂 Estrutura do Projeto

/
|-- src/
|   |-- Biblioteca/
|       |-- Livro.java             # Define o objeto Livro e seus comportamentos.
|       |-- Biblioteca.java        # Define o acervo e gerencia a coleção de livros.
|       |-- SistemaBiblioteca.java # Classe principal com o método main e o menu interativo.
|-- .gitignore
|-- README.md


## ✒️ Autor

Projeto desenvolvido por **Davi Garutti**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/davigarutti/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/SEU-USUARIO-DO-GITHUB)


## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
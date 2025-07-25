package Biblioteca;

import java.util.Scanner;


public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao = 5;

        do {
            System.out.println("\n--- Menu da Biblioteca ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar todos os Livros");
            System.out.println("3. Emprestar um Livro");
            System.out.println("4. Devolver um Livro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcao = 6;
            }

            switch (opcao) {
                case 1:
                    try {
                        adicionarLivro(scanner, biblioteca);
                    } catch (Exception e) {
                        System.out.println("Um erro ocorreu ao tentar adicionar o livro");
                    }
                    break;
                case 2:
                    biblioteca.listarLivros();
                    System.out.println();
                    break;
                case 3:
                    emprestarLivro(scanner, biblioteca);
                    break;
                case 4:
                    devolverLivro(scanner, biblioteca);
                    break;
                case 5:
                    System.out.println("Saindo!!");
                    break;
                default:
                    System.out.println("Você digitou um número errado.");
                    break;
            }
        } while (opcao != 5);
    }

    public void parteEstaticaAntiga() {
        Biblioteca minhaBiblioteca = new Biblioteca();
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        Livro livro2 = new Livro("1984", "George Orwell", 1949);
        Livro livro3 = new Livro("Dom Quixote", "Miguel de Cervantes", 1605);

        minhaBiblioteca.addLivro(livro1);
        minhaBiblioteca.addLivro(livro2);
        minhaBiblioteca.addLivro(livro3);

        Livro livroPesquisa = minhaBiblioteca.buscarLivroPorTitulo("1984 diários");
        if (livroPesquisa != null) {
            System.out.println("Livro encontrado!");
            livroPesquisa.emprestar();
            System.out.println("------------------");
            minhaBiblioteca.listarLivros();
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public static void adicionarLivro(Scanner scanner, Biblioteca biblioteca) {

        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine();

        System.out.print("Digite o autor: ");
        String nomeAutor = scanner.nextLine();

        System.out.print("Digite o ano de lançamento: ");
        int anoLancamento = Integer.parseInt(scanner.nextLine());

        Livro livro = new Livro(nomeLivro, nomeAutor, anoLancamento);
        biblioteca.addLivro(livro);

        System.out.println("Livro adicionado com sucesso!");
        System.out.println();
    }

    public static void emprestarLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("Digite o livro deseja pegar emprestado:");
        String livroDesejado = scanner.nextLine();
        Livro livro = biblioteca.buscarLivroPorTitulo(livroDesejado);
        if (livro != null) {
            if(livro.isDisponivel()){
                livro.emprestar();
                System.out.println("O livro foi emprestado!");
                return;
            }
            System.out.println("O livro já está emprestado para outra pessoa");
        } else {
            System.out.println("O livro que deseja não tem em nosso acervo.");
        }
    }

    public static void devolverLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("Digite o livro deseja devolver:");
        String livroDesejado = scanner.nextLine();
        Livro livro = biblioteca.buscarLivroPorTitulo(livroDesejado);
        if (livro != null) {
            livro.devolver();
            System.out.println("O livro devolvido!");
        } else {
            System.out.println("O livro que deseja devolver nunca existiu em nosso acervo.");
        }
    }
}

package BibliotecaComJDBC;

import java.sql.*;

public class Livro {
    private final String titulo;
    private final String autor;
    private final int anoPublicacao;
    private boolean disponivel;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public void emprestar() {
        String sql = "UPDATE Livro " +
                "SET disponivel = FALSE " +
                "WHERE nomeLivro = " + "'" + this.getTitulo() + "'";

        if (!this.disponivel) {
            System.out.println("O livro já foi emprestado");
        }
        else {
            try (Connection conn = Database.getDatabase();
                 PreparedStatement stmt = conn.prepareStatement(sql);) {
                stmt.executeUpdate();
                System.out.println("Livro, " + this.getTitulo() + " emprestado!");

            } catch (SQLException e) {
                System.err.println("Erro ao adicionar livros do banco.");
                e.printStackTrace();
            }
            this.disponivel = false;
        }
    }

    public void devolver() {
        String sql = "UPDATE Livro " +
                "SET disponivel = TRUE " +
                "WHERE nomeLivro = " + "'" + this.getTitulo() + "'";

        if (this.disponivel) {
            System.out.println("O livro já esta disponível.");
        }
        else {
            try (Connection conn = Database.getDatabase();
                 PreparedStatement stmt = conn.prepareStatement(sql);) {
                stmt.executeUpdate();
                System.out.println("Livro, " + this.getTitulo() + " emprestado!");

            } catch (SQLException e) {
                System.err.println("Erro ao adicionar livros do banco.");
                e.printStackTrace();
            }
            this.disponivel = true;
        }
    }

    public void exibirInfo() {
        System.out.println("O nome do livro é: " + getTitulo());
        System.out.println("O autor é: " + getAutor());
        System.out.println("O ano de publicação é: " + getAnoPublicacao());
        System.out.println("Disponibilidade do livro: " + (isDisponivel() ? "Disponível" : "Indisponível"));
    }

}

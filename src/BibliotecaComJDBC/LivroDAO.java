package BibliotecaComJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

    public void emprestar(Livro livro) {
        String sql = "UPDATE Livro " +
                "SET disponivel = FALSE " +
                "WHERE nomeLivro = " + "'" + livro.getTitulo() + "'";

        if (!livro.isDisponivel()) {
            System.out.println("O livro já foi emprestado");
        }
        else {
            try (Connection conn = Database.getDatabase();
                 PreparedStatement stmt = conn.prepareStatement(sql);) {
                stmt.executeUpdate();
                System.out.println("Livro, " + livro.getTitulo() + " emprestado!");

            } catch (SQLException e) {
                System.err.println("Erro ao adicionar livros do banco.");
                e.printStackTrace();
            }
            livro.disponivel = false;
        }
    }

    public void devolver(Livro livro) {
        String sql = "UPDATE Livro " +
                "SET disponivel = TRUE " +
                "WHERE nomeLivro = " + "'" + livro.getTitulo() + "'";

        if (livro.isDisponivel()) {
            System.out.println("O livro já esta disponível.");
        }
        else {
            try (Connection conn = Database.getDatabase();
                 PreparedStatement stmt = conn.prepareStatement(sql);) {
                stmt.executeUpdate();
                System.out.println("Livro, " + livro.getTitulo() + " emprestado!");

            } catch (SQLException e) {
                System.err.println("Erro ao adicionar livros do banco.");
                e.printStackTrace();
            }
            livro.disponivel = true;
        }
    }

}

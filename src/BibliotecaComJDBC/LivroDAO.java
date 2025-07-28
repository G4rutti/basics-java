package BibliotecaComJDBC;

import java.sql.*;

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

    public void addLivro(Livro livro) {
        Biblioteca biblioteca = new Biblioteca();
        String sql = "INSERT INTO Livro (nomeLivro, autorLivro, anoPostagem, disponivel) " +
                "VALUES (" +
                "'" + livro.getTitulo() + "', " +
                "'" + livro.getAutor() + "', " +
                livro.getAnoPublicacao() + ", " +
                "TRUE" +
                ")";

        try (Connection conn = Database.getDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.executeUpdate();
            biblioteca.getAcervo().add(livro);
            System.out.println("Livro, " + livro.getTitulo() + " adicionado com sucesso!");

        }catch (SQLException e) {
            System.err.println("Erro ao adicionar livros do banco.");
            e.printStackTrace();
        }

    }

    public void listarLivros() {
        Biblioteca biblioteca = new Biblioteca();
        String sql = "SELECT * FROM Livro";
        LivroDAO livroDao = new LivroDAO();

        try (Connection conn = Database.getDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            biblioteca.getAcervo().clear();
            while (rs.next()){
                String tituloLivro = rs.getString("nomeLivro");
                String autorLivro = rs.getString("autorLivro");
                int anoPostagem = rs.getInt("anoPostagem");
                boolean disponivel = rs.getBoolean("disponivel");

                Livro livro = new Livro(tituloLivro, autorLivro, anoPostagem);

                if(!disponivel){
                    livroDao.emprestar(livro);
                }

                biblioteca.getAcervo().add(livro);
            }

            if (biblioteca.getAcervo().isEmpty()) {
                System.out.println("Nenhum livro cadastrado no banco.");
            } else {
                for (Livro l : biblioteca.getAcervo()) {
                    l.exibirInfo();
                    System.out.println("-----------------------------");
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar livros do banco.");
            e.printStackTrace();
        }
    }
}

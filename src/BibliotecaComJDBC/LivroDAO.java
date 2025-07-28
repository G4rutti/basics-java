    package BibliotecaComJDBC;

    import java.sql.*;
    import java.util.ArrayList;

    public class LivroDAO {

        public void emprestar(Livro livro) {
            String sql = "UPDATE Livro SET disponivel = False WHERE nomeLivro = ? ";

            if (!livro.isDisponivel()) {
                System.out.println("O livro já foi emprestado");
            } else {
                try (Connection conn = Database.getDatabase();
                     PreparedStatement stmt = conn.prepareStatement(sql);) {
                    stmt.setString(1, livro.getTitulo());
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
            String sql = "UPDATE Livro SET disponivel = True WHERE nomeLivro = ? ";

            if (livro.isDisponivel()) {
                System.out.println("O livro já esta disponível.");
            } else {
                try (Connection conn = Database.getDatabase();
                     PreparedStatement stmt = conn.prepareStatement(sql);) {
                    stmt.setString(1, livro.getTitulo());
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
            String sql = "INSERT INTO Livro (nomeLivro, autorLivro, anoPostagem) VALUES (?, ?, ?)";


            try (Connection conn = Database.getDatabase();
                 PreparedStatement stmt = conn.prepareStatement(sql);) {

                stmt.setString(1, livro.getTitulo());
                stmt.setString(2, livro.getAutor());
                stmt.setInt(3, livro.getAnoPublicacao());

                stmt.executeUpdate();
                biblioteca.getAcervo().add(livro);
                System.out.println("Livro, " + livro.getTitulo() + " adicionado com sucesso!");

            } catch (SQLException e) {
                System.err.println("Erro ao adicionar livros do banco.");
                e.printStackTrace();
            }

        }

        public ArrayList<Livro> buscarTodosOsLivros() {
            ArrayList<Livro> listaDeLivros = new ArrayList<>();
            String sql = "SELECT * FROM Livro";

            try (Connection conn = Database.getDatabase();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    String tituloLivro = rs.getString("nomeLivro");
                    String autorLivro = rs.getString("autorLivro");
                    int anoPostagem = rs.getInt("anoPostagem");
                    boolean disponivel = rs.getBoolean("disponivel");

                    Livro livro = new Livro(tituloLivro, autorLivro, anoPostagem);
                    livro.disponivel = disponivel;

                    listaDeLivros.add(livro);
                }
            } catch (SQLException e) {
                System.err.println("Erro ao buscar livros do banco.");
                e.printStackTrace();
            }
            return listaDeLivros;
        }
    }

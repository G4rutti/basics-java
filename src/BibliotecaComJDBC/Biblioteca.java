package BibliotecaComJDBC;

import java.sql.*;
import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Livro> acervo;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    public void addLivro(Livro livro) {
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
            this.acervo.add(livro);
            System.out.println("Livro, " + livro.getTitulo() + " adicionado com sucesso!");

        }catch (SQLException e) {
            System.err.println("Erro ao adicionar livros do banco.");
            e.printStackTrace();
        }

    }

    public void listarLivros() {
        String sql = "SELECT * FROM Livro";

        try (Connection conn = Database.getDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            acervo.clear();
            while (rs.next()){
                String tituloLivro = rs.getString("nomeLivro");
                String autorLivro = rs.getString("autorLivro");
                int anoPostagem = rs.getInt("anoPostagem");
                boolean disponivel = rs.getBoolean("disponivel");

                Livro livro = new Livro(tituloLivro, autorLivro, anoPostagem);

                if(!disponivel){
                    livro.emprestar();
                }

                acervo.add(livro);

                if (acervo.isEmpty()) {
                    System.out.println("Nenhum livro cadastrado no banco.");
                } else {
                    for (Livro l : acervo) {
                        l.exibirInfo();
                        System.out.println("-----------------------------");
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar livros do banco.");
            e.printStackTrace();
        }

        for (Livro l : this.acervo) {
            l.exibirInfo();
        }
    }

    public Livro buscarLivroPorTitulo(String tituloBusca) {

        for(Livro l: acervo){
            if(l.getTitulo().equalsIgnoreCase(tituloBusca)){
                return l;
            }
        }
        return null;
    }


}

package BibliotecaComJDBC;

import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Livro> acervo;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    public ArrayList<Livro> getAcervo(){
        return acervo;
    }

    public Livro buscarLivroPorTitulo(String tituloBusca) {
        for(Livro l: acervo){
            if(l.getTitulo().equalsIgnoreCase(tituloBusca)){
                return l;
            }
        }
        return null;
    }

    public void listarLivros() {
        LivroDAO livroDao = new LivroDAO();
        ArrayList<Livro> livrosDoBanco = livroDao.buscarTodosOsLivros();
        this.acervo.clear(); // Limpa o acervo antigo
        this.acervo.addAll(livrosDoBanco); // Adiciona todos os livros novos

        // 2. Agora, imprime o acervo que foi atualizado
        if (this.acervo.isEmpty()) {
            System.out.println("Nenhum livro cadastrado no banco.");
        } else {
            System.out.println("--- Lista de Livros no Acervo ---");
            for (Livro l : this.acervo) {
                l.exibirInfo();
                System.out.println("-----------------------------");
            }
        }
    }
}

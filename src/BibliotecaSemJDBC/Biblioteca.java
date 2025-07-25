package BibliotecaSemJDBC;

import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Livro> acervo;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    public void addLivro(Livro livro) {
        this.acervo.add(livro);
        System.out.println("Livro, " + livro.getTitulo() + " adicionado com sucesso!");
    }

    public void listarLivros() {
        if (acervo.isEmpty()) {
            System.out.println("A biblioteca não possui livros no acervo.");
            return;
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

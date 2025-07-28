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
}

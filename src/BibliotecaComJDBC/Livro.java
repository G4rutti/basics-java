package BibliotecaComJDBC;

public class Livro {
    private final String titulo;
    private final String autor;
    private final int anoPublicacao;
    public boolean disponivel;

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

    public void exibirInfo() {
        System.out.println("O nome do livro é: " + getTitulo());
        System.out.println("O autor é: " + getAutor());
        System.out.println("O ano de publicação é: " + getAnoPublicacao());
        System.out.println("Disponibilidade do livro: " + (isDisponivel() ? "Disponível" : "Indisponível"));
    }
}

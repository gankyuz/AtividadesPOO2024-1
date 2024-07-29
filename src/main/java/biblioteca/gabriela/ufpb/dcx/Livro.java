package biblioteca.gabriela.ufpb.dcx;

import java.util.Objects;

public class Livro implements Comparable<Livro> {

    public String nome;
    public String autor;

    public Livro(String nome, String autor) {
        this.nome = nome;
        this.autor = autor;
    }
    public Livro() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        if (!Objects.equals(nome, livro.nome)) return false;
        return Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Livro o) {
        return this.nome.compareTo(o.getNome());
    }
}

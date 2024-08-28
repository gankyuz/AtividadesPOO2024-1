package biblioteca.gabriela.ufpb.dcx;

import biblioteca.gabriela.ufpb.dcx.gravador.GravadorDeDados;

import java.io.IOException;
import java.util.*;

public class SistemaBibliotecaMap{

    public Map<String,Livro> livros;
    public GravadorDeDados gravador;

    public SistemaBibliotecaMap(){
        this.livros = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }


    public void cadastrarLivro(Livro livro) throws LivroJaExistenteException {
        if (livros.containsKey(livro)){
            throw new LivroJaExistenteException("LIVRO JÁ EXISTENTE NO SISTEMA");
        }
        livros.put(livro.nome, livro);
    }


    public Collection<Livro> pesquisarLivro(String nome, String autor) {
        Collection<Livro> pesquisaLivro = new LinkedList<>();
        for (Livro c: livros.values()){
            if (c.nome.equals(nome) && c.autor.equals(autor)){
                pesquisaLivro.add(c);
            }
        }
        return pesquisaLivro;
    }


    public Map<String, Livro> listarLivros() {
        return this.livros;
    }


    public void removerLivro(String nome) {
        for(Livro p: livros.values()){
            if (p.nome.equals(nome)) livros.remove(p);
        }
    }
    public void gravaDados(){
        try {
            gravador.gravaLivros(this.livros);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
    public void recuperaDados(){
        try{
            this.livros = gravador.recuperaLivros();
        }catch (IOException a){
            System.err.println(a.getMessage());
            this.livros = new HashMap<>();
        }
    }
}

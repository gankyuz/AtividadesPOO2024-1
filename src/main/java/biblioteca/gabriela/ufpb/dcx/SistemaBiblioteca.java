package biblioteca.gabriela.ufpb.dcx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SistemaBiblioteca implements InterfaceSistemaBiblioteca{

    public List<Livro> livros;

    public SistemaBiblioteca(){
        this.livros= new LinkedList<>();
    }
    @Override
    public void cadastrarLivro(Livro livro) throws LivroJaExistenteException {
        List<Livro> cadastro = new LinkedList<>();
        for (Livro a: livros){
            if (a.nome.equals(livro.nome)&&a.autor.equals(livro.autor)){
                throw new LivroJaExistenteException("Esse livro já existe");
            }else{
                cadastro.add(a);
            }
        }
    }

    @Override
    public List<Livro> pesquisarLivro(String nome, String autor) {
        List<Livro> livrosPesquisa= new LinkedList<>();
        for (Livro pesquisa: livros){
            if (pesquisa.nome.equals(nome) && pesquisa.autor.equals(autor)){
                livrosPesquisa.add(pesquisa);
            }
        }
        return livrosPesquisa;
    }

    @Override
    public List<Livro> listarLivros() {
        return livros;
    }

    @Override
    public void removerLivro(String nome) {
        for (Livro a: livros){
            if (a.nome.equals(nome)){
                livros.remove(a);
            }
        }
    }
}

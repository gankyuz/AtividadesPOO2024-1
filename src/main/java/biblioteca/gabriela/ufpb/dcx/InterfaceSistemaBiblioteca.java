package biblioteca.gabriela.ufpb.dcx;

import java.util.List;

public interface InterfaceSistemaBiblioteca {

    public void cadastrarLivro(Livro livro) throws LivroJaExistenteException;

    public List<Livro> pesquisarLivro(String nome, String autor);
    public List<Livro> listarLivros();

    public void removerLivro(String nome);

}

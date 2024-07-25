package Artesanato;

import Artesanato.Exceptions.CodigoInvalidoException;
import Artesanato.Exceptions.ItemInexistenteException;
import Artesanato.Exceptions.ItemJaExisteException;

import java.util.List;

/**
 * Sistema para gerenciar itens de artesanato.
 */
public interface SistemaFeiraArtesanato {
    /**
     * Cadastra um novo item no sistema.
     * @param item O item a ser adicionado
     */
    public void cadastrarItem(ItemDeArtesanato item) throws CodigoInvalidoException, ItemJaExisteException;
    /**
     * Pesquisa todos os itens cuja nome começa com o nome passado como parâmetro
     * @param nome O nome a pesquisar
     * @return uma lista contendo os itens cujo nome começa com o parâmetro passado.
     */
    public List<ItemDeArtesanato> pesquisarItensPeloNome(String nome);

    /**
     * Pesquisa os itens cujo preço é menor ou igual ao valor passado no parâmetro
     * @param preco o valor dos itens a pesquisar
     * @return a lista dos itens cuja preço é menor ou igual ao valor passado no parâmetro
     */
    public List<ItemDeArtesanato> pesquisarItensAbaixoDoPreco(double preco);

    /**
     * Pesquisa o item cujo o código é passado por parâmetro
     * @param codigo O código do item a pesquisar
     * @return O item encontrado
     * @throws ItemInexistenteException Se não for encontrado nenhum item com o código passado.
     */
    public ItemDeArtesanato pesquisaItensPeloCodigo(String codigo) throws ItemInexistenteException;

}

package SistemaComercial;

import SistemaComercial.Exceptions.ClienteNaoExisteException;
import SistemaComercial.Exceptions.ProdutoNaoExisteException;

import java.util.Collection;

public interface SistemaComercial {
    boolean existeProduto(Produto produto);
    Produto pesquisaProduto(String codigoProduto) throws ProdutoNaoExisteException;
    boolean cadastrarProduto(Produto produto);
    boolean existeCliente(Cliente cliente);
    Cliente pesquisaCliente(String id) throws ClienteNaoExisteException;
    Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria);
}

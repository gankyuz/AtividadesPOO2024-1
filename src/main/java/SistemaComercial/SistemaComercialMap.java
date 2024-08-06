package SistemaComercial;

import SistemaComercial.Exceptions.ClienteNaoExisteException;
import SistemaComercial.Exceptions.ProdutoNaoExisteException;

import java.util.*;

public class SistemaComercialMap implements SistemaComercial{

    private Map<String, Cliente> clientes;
    private Map<String, Produto> produtos;

    public SistemaComercialMap(){
        this.clientes = new HashMap<String, Cliente>();
        this.produtos = new HashMap<String, Produto>();
    }
    @Override
    public boolean existeProduto(Produto produto) {
        if (this.produtos.containsKey(produto.getCodigo())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Produto pesquisaProduto(String codigoProduto) throws ProdutoNaoExisteException {
        if (this.produtos.containsKey(codigoProduto)){
            return this.produtos.get(codigoProduto);
        }
        throw new ProdutoNaoExisteException("Não foi encontrado produto"+" com código"+codigoProduto);
    }

    @Override
    public boolean cadastrarProduto(Produto produto) {
        if (existeProduto(produto)){
            return false;
        }else {
            this.produtos.put(produto.getCodigo(), produto);
            return true;
        }
    }

    @Override
    public boolean existeCliente(Cliente cliente) {
        if (this.clientes.containsKey(cliente)){
            return true;
        }
        return false;
    }

    @Override
    public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException {
        for (Cliente clientePesq: this.clientes.values()){
            if (clientePesq.getId().equals(id)){
                return clientePesq;
            }
        }
        throw new ClienteNaoExisteException("ESTE CLIENTE NÃO EXISTE");
    }

    @Override
    public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria) {
        Collection<Produto> produtoCategoria = new ArrayList<>();
        for (Produto produtoPesqCategoria: this.produtos.values()){
            if (produtoPesqCategoria.getCategoria() == categoria){
                produtoCategoria.add(produtoPesqCategoria);
            }
        }
        return produtoCategoria;
    }
}

package SistemaComercial;

import SistemaComercial.Exceptions.ProdutoNaoExisteException;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaComercialMapTest {
    @Test
    public void testaCadastroProdutos(){
        SistemaComercialMap sistema = new SistemaComercialMap();
        Collection<Produto> alimentos = sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
        assertTrue(alimentos.size() == 0);

        //Cadastro
        Produto produtoTeste = new Produto("123","Casadinho", 5.0, 4, CategoriaProduto.ALIMENTO);
        Produto produtoTesteDois = new Produto("321","nana", 1.0, 5, CategoriaProduto.ALIMENTO);
        sistema.cadastrarProduto(produtoTeste);
        sistema.cadastrarProduto(produtoTesteDois);

        //Verificar se existe
        //Verificar quantidade
        alimentos = sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
        assertEquals(2, alimentos.size());
    }

}

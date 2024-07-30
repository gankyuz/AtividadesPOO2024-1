package Artesanato;

import Artesanato.Exceptions.CodigoInvalidoException;
import Artesanato.Exceptions.ItemInexistenteException;
import Artesanato.Exceptions.ItemJaExisteException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.fail;

public class SistemaFeiraArtesanatoRioTintoTest {
    @Test
    public void testaCadastro(){
        SistemaFeiraArtesanatoRioTinto sistema = new SistemaFeiraArtesanatoRioTinto();
        try{
            Roupa r = new Roupa();
            sistema.cadastrarItem(r);
            ItemDeArtesanato item = sistema.pesquisaItensPeloCodigo(r.getCodigo());
        }catch (CodigoInvalidoException e){
            fail();
        }catch (ItemJaExisteException e){
            fail();
        }catch (ItemInexistenteException e){
            fail();
        }
    }
}

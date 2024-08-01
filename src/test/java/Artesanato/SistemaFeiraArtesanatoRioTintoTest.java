package Artesanato;

import Artesanato.Exceptions.CodigoInvalidoException;
import Artesanato.Exceptions.ItemInexistenteException;
import Artesanato.Exceptions.ItemJaExisteException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SistemaFeiraArtesanatoRioTintoTest {
    @Test
    public void testaCadastro(){
        SistemaFeiraArtesanatoRioTinto sistema = new SistemaFeiraArtesanatoRioTinto();
        try{
            Roupa r = new Roupa();
            sistema.cadastrarItem(r);
            fail("Não deve deixar cadastrar");
        }catch (CodigoInvalidoException e){
            //ok
        }catch (ItemJaExisteException e) {
            fail("Não era para lançar exceptions");
        }
    }
}

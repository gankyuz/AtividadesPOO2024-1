package AmigoSecreto.AmigoSecreto;

import AmigoSecreto.AmigoSecreto.Exceptions.AmigoExistenteException;
import AmigoSecreto.AmigoSecreto.Exceptions.AmigoNaoCadastradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaAmigoMapTest {

    SistemaAmigoMap sistema;

    @BeforeEach
    void setUp(){
        this.sistema = new SistemaAmigoMap();
    }

    @Test
    void testPesquisaECadastraAmigoMap() {
        assertThrows(AmigoNaoCadastradoException.class, () -> sistema.pesquisaAmigo("gabi@gmail.com"));

        try {
            sistema.CadastraAmigoMap("Gabi", "gabi@gmail.com");
            Amigo a = sistema.pesquisaAmigo("gabi@gmail.com");
            assertEquals("gabi", a.getNome());
            assertEquals("gabi@gmail.com", a.getEmail());
        }catch (AmigoExistenteException | AmigoNaoCadastradoException e){
            fail("Não deveria lançar exceção");
        }
    }

}

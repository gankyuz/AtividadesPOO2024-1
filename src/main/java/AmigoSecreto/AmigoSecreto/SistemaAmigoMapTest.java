package AmigoSecreto.AmigoSecreto;

import AmigoSecreto.AmigoSecreto.Exceptions.AmigoExistenteException;
import AmigoSecreto.AmigoSecreto.Exceptions.AmigoNaoCadastradoException;
import AmigoSecreto.AmigoSecreto.Exceptions.ListaVaziaException;
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
    void testSistemaAmigo(){
        try {
            assertTrue(sistema.pesquisaTodasAsMensagensMap().isEmpty());
        }catch (ListaVaziaException | AmigoExistenteException e){
            assertThrows(AmigoNaoCadastradoException.class, () -> sistema.pesquisaAmigoMap("gabi@gmail.com"));
        }
    }
    @Test
    void testPesquisaECadastraAmigoMap(){
        try {
            sistema.pesquisaAmigoMap("ayla@teste.com");
            fail("Deveria falhar pois não existe ainda");
        }catch (AmigoNaoCadastradoException e){
            //OK
        }
        try {
            sistema.cadastraAmigoMap("ayla", "ayla@teste.com");
            Amigo a = sistema.pesquisaAmigoMap("ayla@teste.com");
            assertEquals("ayla",a.getNome());
            assertEquals("ayla@teste.com", a.getEmail());
        }catch (AmigoExistenteException | AmigoNaoCadastradoException e){
            fail("Não deveriam lançar exceção");
        }
    }
}

package AmigoSecreto.AmigoSecreto;


import AmigoSecreto.AmigoSecreto.Exceptions.AmigoExistenteException;
import AmigoSecreto.AmigoSecreto.Exceptions.AmigoNaoCadastradoException;
import AmigoSecreto.AmigoSecreto.Exceptions.ListaVaziaException;

import java.util.*;

public class SistemaAmigoMap {

    private Map<String, Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap() {
        this.mensagens = new HashMap<>();
        this.amigos = new HashMap<>();
    }

    public void CadastraAmigoMap(String nomeAmigo, String emailAmigo) throws AmigoExistenteException {
        if (amigos.containsKey(nomeAmigo)){
            throw new AmigoExistenteException("Amigo já cadastrado");
        }
        Amigo cadastro = new Amigo(nomeAmigo,emailAmigo);
        amigos.put(nomeAmigo, cadastro);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoNaoCadastradoException{
        if (!this.amigos.containsKey(emailAmigo)){
            throw new AmigoNaoCadastradoException("Amigo não cadastrado");
        }
        return this.amigos.get(emailAmigo);
    }
}

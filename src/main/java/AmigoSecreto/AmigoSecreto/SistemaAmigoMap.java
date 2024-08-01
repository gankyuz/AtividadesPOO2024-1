package AmigoSecreto.AmigoSecreto;


import AmigoSecreto.AmigoSecreto.Exceptions.AmigoExistenteException;
import AmigoSecreto.AmigoSecreto.Exceptions.AmigoNaoCadastradoException;
import AmigoSecreto.AmigoSecreto.Exceptions.AmigoSorteadoNaoCadastradoException;
import AmigoSecreto.AmigoSecreto.Exceptions.ListaVaziaException;

import java.util.*;

public class SistemaAmigoMap {

    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap() {
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigoMap(String nomeAmigo, String emailAmigo) throws AmigoExistenteException {
        if (amigos.containsKey(emailAmigo)){
            throw new AmigoExistenteException("Amigo já cadastrado");
        }
        Amigo cadastro = new Amigo(nomeAmigo,emailAmigo);
        amigos.put(nomeAmigo, cadastro);
    }

    public Amigo pesquisaAmigoMap(String emailAmigo) throws AmigoNaoCadastradoException, ListaVaziaException{
        List<Amigo> listaPesquisa = new ArrayList<>();
        if (amigos.isEmpty()) throw new ListaVaziaException("A lista está vazia");
        for (Amigo amigoPesquisa: this.amigos.values()) {
            if (amigoPesquisa.getEmail().equals(emailAmigo)) {
                return amigoPesquisa;
            }
        }
        throw new AmigoNaoCadastradoException("Amigo não cadastrado");
    }

}

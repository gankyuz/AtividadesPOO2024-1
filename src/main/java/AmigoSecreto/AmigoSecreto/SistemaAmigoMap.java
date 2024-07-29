package AmigoSecreto.AmigoSecreto;


import AmigoSecreto.AmigoSecreto.Exceptions.AmigoExistenteException;
import AmigoSecreto.AmigoSecreto.Exceptions.AmigoNaoCadastradoException;
import AmigoSecreto.AmigoSecreto.Exceptions.AmigoSorteadoNaoCadastradoException;
import AmigoSecreto.AmigoSecreto.Exceptions.ListaVaziaException;

import java.util.*;

public class SistemaAmigoMap {

    private Map<String, Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap() {
        this.mensagens = new HashMap<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigoMap(String nomeAmigo, String emailAmigo) throws AmigoExistenteException {
        if (amigos.containsKey(nomeAmigo)){
            throw new AmigoExistenteException("Amigo já cadastrado");
        }
        Amigo cadastro = new Amigo(nomeAmigo,emailAmigo);
        amigos.put(nomeAmigo, cadastro);
    }

    public Amigo pesquisaAmigoMap(String nomeAmigo) throws AmigoNaoCadastradoException{
        List<Amigo> listaPesquisa = new ArrayList<>();
        Amigo pesquisa = new Amigo();
        if (amigos.containsKey(nomeAmigo)) {
            throw new AmigoNaoCadastradoException("Amigo não cadastrado");
        }
        for (Amigo a: this.amigos.values()) {
            if (a.equals(nomeAmigo)) {
                pesquisa = new Amigo(a.getNome(), a.getEmail());
            }
        }
        return pesquisa;
    }

    public void enviarMensagemParaTodosMap(String texto, String emailRemetente, boolean ehAnonima){
        this.mensagens.put(mensagens.toString(), new MensagemParaTodos(texto, emailRemetente, ehAnonima));
    }
    public void enviarMensagemParaAlguemMap(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        this.mensagens.put(mensagens.toString(), new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima));
    }
    public List<Mensagem> pesquisaMensagensAnonimasMap() throws ListaVaziaException{
        List<Mensagem> mensagemsAnonimas = new LinkedList<>();
        if (mensagens.isEmpty()) throw new ListaVaziaException("Lista de mensagens está vazia");
        for(Mensagem mensagemAnonima: this.mensagens.values()){
            if (mensagemAnonima.isAnonima()){
                mensagemsAnonimas.add(mensagemAnonima);
            }
        }
        return mensagemsAnonimas;
    }

    public Map<String, Mensagem> pesquisaTodasAsMensagensMap() throws ListaVaziaException, AmigoExistenteException{
        if (this.mensagens.isEmpty()) throw new ListaVaziaException("Lista de amigos está vazia");
        return this.mensagens;
    }

    public void configuraAmigoSecretoDeMap(String emailDaPessoa, String emailAmigoSorteado) throws ListaVaziaException, AmigoNaoCadastradoException{
        if (this.amigos.isEmpty())throw new ListaVaziaException("Lista de amigos está vazia");
        for (Amigo amigoPesq: this.amigos.values()){
            if (amigoPesq.getEmail().equals(emailDaPessoa)){
                amigoPesq.setEmailAmigoSorteado(emailAmigoSorteado);
            }
        }
    }
    public String pesquisaAmigoSecretoDeMap(String emailDaPessoa) throws ListaVaziaException, AmigoNaoCadastradoException, AmigoSorteadoNaoCadastradoException {
        if (this.amigos.isEmpty()) throw new ListaVaziaException("Lista de amigos está vazia");

        for (Amigo amigoSecreto: this.amigos.values()){
            if (amigoSecreto.getEmail().equals(emailDaPessoa)){
                if (amigoSecreto.getEmailAmigoSorteado().equals("")){
                    throw new AmigoSorteadoNaoCadastradoException("Não houve um sorteio para esse amigo");
                }else{
                    return amigoSecreto.getEmailAmigoSorteado();
                }
            }
        }
        throw new AmigoNaoCadastradoException("Amigo desse email não cadastrado");
    }
}

package AmigoSecreto.AmigoSecreto;

import AmigoSecreto.AmigoSecreto.Exceptions.AmigoExistenteException;
import AmigoSecreto.AmigoSecreto.Exceptions.AmigoNaoCadastradoException;
import AmigoSecreto.AmigoSecreto.Exceptions.AmigoSorteadoNaoCadastradoException;
import AmigoSecreto.AmigoSecreto.Exceptions.ListaVaziaException;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }
    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoExistenteException {
        for(Amigo a: amigos){
            if (a.getNome().equals(nomeAmigo) && a.getEmail().equals(emailAmigo)){
                throw new AmigoExistenteException("Amigo já cadastrado");
            }else {
                Amigo cadastro = new Amigo(nomeAmigo, emailAmigo);
                this.amigos.add(cadastro);
            }
        }
    }
    public Amigo pesquisaAmigo(String amigo) throws ListaVaziaException, AmigoNaoCadastradoException {
        List<Amigo> listaPesquisa = new ArrayList<>();

        if (amigo.isEmpty()) throw new ListaVaziaException("A lista de amigos está vazia");
        for (Amigo amigoPesquisa: amigos){
           if (amigoPesquisa.getNome().equals(amigo)){
               return amigoPesquisa;
           }
        }
        throw new AmigoNaoCadastradoException("Amigo não cadastrado");
    }
    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        this.mensagens.add(new MensagemParaTodos(texto, emailRemetente, ehAnonima));
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        this.mensagens.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() throws ListaVaziaException{
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        if (mensagens.isEmpty()) throw new ListaVaziaException("Lista de mensagens está vazia");
        for (Mensagem mensagemAnonima: this.mensagens){
            if (mensagemAnonima.isAnonima()){
                mensagensAnonimas.add(mensagemAnonima);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() throws ListaVaziaException, AmigoNaoCadastradoException{
        if (this.mensagens.isEmpty()) throw new ListaVaziaException("Lista de mensagens está vazia");
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws ListaVaziaException, AmigoNaoCadastradoException{
        if (this.amigos.isEmpty()) throw new ListaVaziaException("Lista de amigos está vazia");
        for (Amigo amigoPesq: amigos){
            if (amigoPesq.getEmail().equals(emailDaPessoa)){
                amigoPesq.setEmailAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoNaoCadastradoException("Amigo não cadastrado");
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws ListaVaziaException, AmigoNaoCadastradoException, AmigoSorteadoNaoCadastradoException {
        if (this.amigos.isEmpty()) throw new ListaVaziaException("Lista de amigos está vazia");

        for (Amigo amigoSecreto: this.amigos){
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

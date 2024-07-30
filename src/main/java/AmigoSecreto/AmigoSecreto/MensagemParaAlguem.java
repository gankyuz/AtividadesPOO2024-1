package AmigoSecreto.AmigoSecreto;

public class MensagemParaAlguem extends Mensagem{

    private String emailDestinatario;
    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima){
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir(){
        if(isAnonima()){
            String emailDestinatario = this.emailDestinatario;
            String texto = getTexto();
            return "Mensagem para: "+this.emailDestinatario+
                    "\nenviado de forma anônima!"+
                    "\nTexto: "+ texto;
        }else{
            String emailDestinatario = this.emailDestinatario;
            String texto = getTexto();
            String emailRemetente = getEmailRemetente();
            return "De: "+emailRemetente+
                    "\nPara: "+ emailDestinatario+
                    "\nTexto: "+texto;
        }
    }

    @Override
    public String toString() {
        return "MensagemParaAlguem\n" +
                "Email Destinatário: "+ emailDestinatario;
    }
}

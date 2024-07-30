package AmigoSecreto.AmigoSecreto;

public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        super(texto, emailRemetente, false);
    }
    @Override
    public String getTextoCompletoAExibir(){
        if (isAnonima()){
            String texto = getTexto();
            return "Esse email foi enviado para todos de forma anônima"+
                    "\nTexto: "+texto;
        }else{
            String texto = getTexto();
            String emailRemetente = getEmailRemetente();
            return "De: "+emailRemetente+
                    "\nPara: Todos"+
                    "\nTexto: "+texto;
        }
    }
    public String toString(){
        return "Mensagem Para Todos\n"+
                "Mensagem: "+this.getTexto()+
                "\nEmail Remetente: "+this.getEmailRemetente();
    }
}

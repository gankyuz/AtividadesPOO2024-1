package AmigoSecreto.AmigoSecreto;

public class Amigo {

    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public Amigo(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public Amigo(){
        this("","");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String emailAmigoSorteado) {
        this.emailAmigoSorteado = emailAmigoSorteado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amigo amigo = (Amigo) o;
        return nome.equals(amigo.nome) && email.equals(amigo.email) && emailAmigoSorteado.equals(amigo.emailAmigoSorteado);
    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + emailAmigoSorteado.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", emailAmigoSorteado='" + emailAmigoSorteado + '\'' +
                '}';
    }
}

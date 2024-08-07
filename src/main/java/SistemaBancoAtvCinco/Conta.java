package SistemaBancoAtvCinco;

public class Conta extends Cliente{
    private int numero;
    private double saldoInicio;

    public Conta(String nome, int numero, double saldoInicio){
        super(nome);
        this.numero = numero;
        this.saldoInicio = saldoInicio;
    }

    public String getNomeCliente(){
        return getNome();
    }
    public int getNumero() {
        return numero;
    }

    public double getSaldoInicio() {
        return saldoInicio;
    }
    public Cliente getCliente(){
        return getCliente();
    }
    public boolean debitar(double valor){
        this.saldoInicio = saldoInicio+=valor;
        return true;
    }
    public void creditar(double valor){
        this.saldoInicio = saldoInicio - valor;
    }
}

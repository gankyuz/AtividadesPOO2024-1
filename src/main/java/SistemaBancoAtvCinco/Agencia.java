package SistemaBancoAtvCinco;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Agencia {

    private int numero;
    private Map<Integer, Conta> contas;

    public Agencia(int numero, Map<Integer, Conta> contas){
        this.numero= numero;
        this.contas = contas;
    }

    public int getNumero() {
        return numero;
    }
    public boolean adicionarConta(Conta c){
        String nomeC = c.getNome();
        int numC = c.getNumero();
        double saldoC = c.getSaldoInicio();
        Conta novaConta = new Conta(nomeC, numC,saldoC);
        return true;
    }
    public Conta pesquisarConta(int numConta){
        List<Conta> contaPesq = new ArrayList<>();
        for (Conta a: this.contas.values()) {
            if (a.getNumero() == numConta) {
                contaPesq.add(a);
            }
        }
        return null;
    }
}

package AmigoSecreto.AmigoSecreto;

import AmigoSecreto.AmigoSecreto.Exceptions.AmigoExistenteException;



import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();

        System.out.println("Quantos amigos irão participar?");
        int quantAmigos = leitor.nextInt();

        for (int k=0; k<quantAmigos; k++){
            System.out.println("Qual o seu nome?");
            String nomeAmigo = leitor.nextLine();
            System.out.println("Qual o seu email?");
            String email = leitor.nextLine();
            try {
                sistema.cadastraAmigo(nomeAmigo, email);
            }catch (AmigoExistenteException e){
                e.printStackTrace();
            }
        }
    }
}

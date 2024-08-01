package AmigoSecreto.AmigoSecreto;

import AmigoSecreto.AmigoSecreto.Exceptions.AmigoExistenteException;
import AmigoSecreto.AmigoSecreto.Exceptions.AmigoNaoCadastradoException;
import AmigoSecreto.AmigoSecreto.Exceptions.ListaVaziaException;
import Artesanato.SistemaFeiraArtesanato;
import Artesanato.SistemaFeiraArtesanatoRioTinto;

import javax.swing.*;
import java.util.Scanner;

public class ProgramaAmigoSecreto {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();
        SistemaAmigoMap sistemaMap = new SistemaAmigoMap();
        try{
            sistema.cadastraAmigo("Gabriela", "gabi@gmail.com");
            sistemaMap.cadastraAmigoMap("Vitória", "vitoria@gmail.com");
        }catch (AmigoExistenteException e){
            System.out.println(e);
        }

        sistema.enviarMensagemParaAlguem("eai", "gabi@gmail.com", "vitoria@gmail.com", false);
        /**sistemaMap.enviarMensagemParaAlguemMap("lala", "vitoria@gmail.com","gabi@gmail.com", true);

        try{
            System.out.print(sistemaMap.pesquisaMensagensAnonimasMap());
        }catch (ListaVaziaException e){
            System.out.println(e);
        }try{
            System.out.print("\n"+sistema.pesquisaTodasAsMensagens());
        }catch (ListaVaziaException e){
            System.out.println(e);
        }**/
    }
}

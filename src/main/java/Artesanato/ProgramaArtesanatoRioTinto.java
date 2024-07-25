package Artesanato;

import Artesanato.Exceptions.ItemInexistenteException;

import javax.swing.*;
import java.util.List;

public class ProgramaArtesanatoRioTinto {
    public static void main(String[] args) {
        boolean continuar = true;
        SistemaFeiraArtesanato sistema = new SistemaFeiraArtesanatoRioTinto();
        while (continuar){
            String opcao = JOptionPane.showInputDialog("Digite uma opção:\n1.Cadastrar\n2.Pesquisar pelo nome\n3.Pesquisar pelo código\n4.Sair").toLowerCase();
            if (opcao.equals("1")){

                String tipoItem = JOptionPane.showInputDialog("Qual o tipo de item?\n1.Roupa\n2.Estátua");
                if (tipoItem.equals("1")){
                    Roupa item = new Roupa();
                    String codigo = JOptionPane.showInputDialog("Qual o código?");
                    item.setCodigo(codigo);
                    item.setNome(JOptionPane.showInputDialog("Qual o nome do item?"));
                    item.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Qual o preço do item?")));
                }
                try {
                    sistema.cadastrarItem(item);
                    JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso: " + item.getNome());
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    e.printStackTrace();
                }
            } else if (opcao.equals("2")) {
                String nomeItemAPesquisar = JOptionPane.showInputDialog("Digite o nome do item a pesquisar (Início do nome)");
                List<ItemDeArtesanato> itensPorNome = sistema.pesquisarItensPeloNome(nomeItemAPesquisar);
                if (itensPorNome.size()==0){
                    JOptionPane.showMessageDialog(null, "Não existe nenhum item com esse nome");
                }else {
                    JOptionPane.showMessageDialog(null, "Item encontrado");
                    for (ItemDeArtesanato it: itensPorNome){
                        JOptionPane.showMessageDialog(null, it.toString());
                    }
                }
            } else if (opcao.equals("3")) {
                String codigoPesq = JOptionPane.showInputDialog("Digite o código a pesquisar:");
                try {
                    ItemDeArtesanato itemAchado = sistema.pesquisaItensPeloCodigo(codigoPesq);
                    JOptionPane.showMessageDialog(null, "Item achado:"+itemAchado.toString());
                }catch (ItemInexistenteException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
            } else if (opcao.equals("4")) {
                continuar = false;
                JOptionPane.showMessageDialog(null,"TCHAU VAGABUNDA!");
            }
        }
    }
}

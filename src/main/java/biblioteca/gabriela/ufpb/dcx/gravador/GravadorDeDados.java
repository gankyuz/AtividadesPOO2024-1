package biblioteca.gabriela.ufpb.dcx.gravador;

import biblioteca.gabriela.ufpb.dcx.Livro;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    public static final String ARQUIVO_LIVROS = "catalogo_livros.dat";

    public HashMap<String, Livro> recuperaLivros () throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_LIVROS))){
            return (HashMap<String, Livro>) in.readObject();
        }catch (ClassNotFoundException e){
            throw new IOException(e);
        }
    }
    public void gravaLivros(Map<String, Livro> livros)throws IOException{
        try(ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(ARQUIVO_LIVROS))){
            in.writeObject(livros);
        }
    }
}


package SistemaBibliotecaAtvCinco;

import java.util.List;

public class Livro {
    private String id;
    private String titulo;
    private List<String> autores;
    private boolean estahEmprestado;

    public Livro(String id, String titulo, boolean estahEmprestado, List<String> autores){
        this.id = id;
        this.titulo = titulo;
        this.estahEmprestado = estahEmprestado;
        this.autores = autores;
    }

    public boolean estahEmprestado(){

    }
}

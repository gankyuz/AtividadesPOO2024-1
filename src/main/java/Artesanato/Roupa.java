package Artesanato;

public class Roupa extends ItemDeArtesanato{

    private String material;
    private String tipo;
    private String tamanho;
    public Roupa(String codigo, String nome, double preco, String material, String tipo, String tamanho) {
        super(codigo, nome, preco);
        this.material = material;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public Roupa() {
        this("","",0.0,"","","");
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public String getDescricao(){
        return "Roupa de código "+super.getCodigo()+", de nome "+super.getNome()+", e de tamanho "+this.tamanho;
    }
    public String toString(){
        return this.getDescricao();
    }
}

package Artesanato;

public class Roupa extends ItemDeArtesanato{

    private String material;
    private String tamanho;
    public Roupa(String codigo, String nome, double preco, String material, String tamanho, TipoItem tipo) {
        super(codigo, nome, preco, TipoItem.ROUPA);
        this.material = material;
        this.tamanho = tamanho;
    }

    public Roupa() {
        this("","",0.0,"","", TipoItem.INDEFINIDO);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

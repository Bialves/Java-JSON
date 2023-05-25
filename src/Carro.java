public class Carro {
    private String marca;
    private String cor;
    private String placa;

    public Carro(String marca, String cor, String placa){
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;
    }

    public String getMarca(){
        return marca;
    }

    public String getCor(){
        return cor;
    }

    public String getPlaca(){
        return placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Marca: " + marca
                + " | Cor: " + cor
                + " | Placa: " + placa;
    }
}

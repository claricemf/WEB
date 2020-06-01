package model;

public class ResultadoConsulta {

    private String marca;
    private String modelo;
    private String ano;
    private String km;
    private String cor;
    private String cambio;
    private String valorTratado;

    public void imprimirDados(){
        System.out.println("Marca: "+getMarca());
        System.out.println("Modelo: "+getModelo());
        System.out.println("Ano: "+getAno());
        System.out.println("Km: "+getKm());
        System.out.println("Cor: "+getCor());
        System.out.println("Cambio: "+getCambio());
        System.out.println("valorTratado: "+getValorTratado());
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getValorTratado() {
        return valorTratado;
    }

    public void setValorTratado(String valorTratado) {
        this.valorTratado = valorTratado;
    }
}

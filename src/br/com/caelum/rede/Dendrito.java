package br.com.caelum.rede;

public class Dendrito {

    private double entrada;
    private double peso;

    public Dendrito(double peso) {
        this.peso = peso;
    }

    public Dendrito() {}

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}





package br.com.caelum.rede;

import br.com.caelum.funcs.FuncaoDeAtivacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Neuronio {

    private List<Dendrito> dendritos = new ArrayList<>();

    private double axonio;

    private FuncaoDeAtivacao funcao;


    public Neuronio(int numeroDeDendritos, FuncaoDeAtivacao funcao, double pesoMin, double pesoMax) {

        for(int i = 0; i < numeroDeDendritos; i++) {
            var aleatorio = new Random().nextDouble();

            aleatorio = pesoMin + (aleatorio * (pesoMax + pesoMin));

            dendritos.add(new Dendrito(aleatorio));
        }


        this.funcao = funcao;
    }

    public Neuronio() {}


    public void ativa() {
        double soma = 0.0;

        for(Dendrito dendrito : dendritos) {
            soma += dendrito.getEntrada() * dendrito.getPeso();
        }

        axonio = funcao.ativa(soma);
    }

    public List<Dendrito> getDendritos() {
        return dendritos;
    }

    public void setDendritos(List<Dendrito> dendritos) {
        this.dendritos = dendritos;
    }

    public double getAxonio() {
        return axonio;
    }

    public void setAxonio(double axonio) {
        this.axonio = axonio;
    }

    public FuncaoDeAtivacao getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoDeAtivacao funcao) {
        this.funcao = funcao;
    }
}

package br.com.caelum.funcs;

public class Sigmoide implements FuncaoDeAtivacao {


    @Override
    public double ativa(double entrada) {
        return 1 / (1 + Math.exp(entrada));
    }
}

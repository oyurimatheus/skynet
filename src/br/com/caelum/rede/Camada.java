package br.com.caelum.rede;

import br.com.caelum.funcs.FuncaoDeAtivacao;

import java.util.ArrayList;
import java.util.List;

public class Camada {

    private List<Neuronio> neuronios = new ArrayList<>();

    public Camada(int numeroDeNeuronios, int numeroDeDendritos,
                  FuncaoDeAtivacao funcaoDeAtivacao,
                  double pesoMin, double pesoMax) {

        for(int i = 0; i < numeroDeNeuronios; i++) {
            var neuronio = new Neuronio(numeroDeDendritos, funcaoDeAtivacao, pesoMin, pesoMax);

            neuronios.add(neuronio);
        }

    }

    public List<Neuronio> getNeuronios() {
        return neuronios;
    }

    public void setNeuronios(List<Neuronio> neuronios) {
        this.neuronios = neuronios;
    }
}

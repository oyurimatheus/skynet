package br.com.caelum.rede;

import br.com.caelum.funcs.FuncaoDeAtivacao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rede {


    private LinkedList<Camada> camadas = new LinkedList<>();

    public Rede(int numeroDeEntradas, int numeroDeSaidas,
                int numeroDeCamadas, int numeroDeNeuroniosPorCamada,
                FuncaoDeAtivacao funcaoDeAtivacao) {

        var primeiraCamada = new Camada(numeroDeEntradas, numeroDeNeuroniosPorCamada, funcaoDeAtivacao, -2, 2);
        camadas.add(primeiraCamada);

        int numeroDeNeuroniosNaCamadaAnterior = numeroDeEntradas;
        for(int i = 0; i < numeroDeCamadas; i++) {
            var camada = new Camada(numeroDeNeuroniosPorCamada, numeroDeNeuroniosNaCamadaAnterior,
                    funcaoDeAtivacao, -2.0, 2.0);

            camadas.add(camada);
            numeroDeNeuroniosNaCamadaAnterior = camada.getNeuronios().size();
        }

        var camadaDeSaida = new Camada(numeroDeSaidas, numeroDeNeuroniosNaCamadaAnterior,
                funcaoDeAtivacao, -2.0, 2.0);

        camadas.add(camadaDeSaida);
    }

    public double[] pensa(double[] entradas) {

        var camadaAnterior = camadas.remove(0); // entrada


        for(int i = 0; i < camadaAnterior.getNeuronios().size(); i++) {
            var neuronio = camadaAnterior.getNeuronios().get(i);

            neuronio.getDendritos().get(0).setEntrada(entradas[i]);

            neuronio.ativa();
        }

        for(int i = 1; i < camadas.size(); i++) {
            var camada = camadas.get(i);

            for(Neuronio neuronio : camada.getNeuronios()) {
                int indiceDendrito = 0;
                for(Neuronio neuronioDaCamadaAnterior : camadaAnterior.getNeuronios()) {

                    neuronio.getDendritos().get(indiceDendrito).setEntrada(neuronioDaCamadaAnterior.getAxonio());

                    indiceDendrito++;
                }

                neuronio.ativa();
                camadaAnterior = camada;

            }
        }

        double[] resultados = new double[camadaAnterior.getNeuronios().size()];

        int indiceNeuronio = 0;
        for(Neuronio neuronio : camadaAnterior.getNeuronios()) {
            resultados[indiceNeuronio] = neuronio.getAxonio();
        }


        return resultados;
    }

}

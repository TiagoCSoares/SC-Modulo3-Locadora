package org.example.resources.aluguel;

import org.example.entities.Pessoa;
import org.example.entities.Veiculo;

public class Aluguel {


    public void alugarVeiculo(Veiculo veiculo, Pessoa locador, String dataInicio) {
        veiculo.alugarVeiculo(locador, dataInicio);
        locador.associarVeiculo(veiculo);
    }

    public Double devolverVeiculo(Veiculo veiculo, Pessoa locador, String dataFim) {
        Double valor = veiculo.calcularValor(String dataFim);

        veiculo.devolverVeiculo();
        locador.desassociarVeiculo(veiculo);

        return valor;
    }
}

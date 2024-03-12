package org.example.resources.aluguel;

import org.example.entities.Pessoa;
import org.example.entities.Veiculo;

public class Aluguel {

    public void alugarVeiculo(Pessoa locador, Veiculo veiculo) {
        veiculo.alugarVeiculo(locador);
        veiculo.setDataInicio();
    }


    public void alugarVeiculo(Pessoa locador, Veiculo veiculo) {
        veiculo.alugarVeiculo(locador);
        locador.associarVeiculo(veiculo);
    }

    public void devolverVeiculo(Veiculo veiculo, Pessoa pessoa, String dataFim) {
        veiculo.devolverVeiculo();

        Double valor = veiculo.calcularValor(dataFim);

        pessoa.desassociarVeiculo(veiculo);
    }

    public void devolverVeiculo(Veiculo veiculo, Pessoa pessoa) {
        veiculo.devolverVeiculo();
        pessoa.desassociarVeiculo(veiculo);
    }
}

package org.example.resources.aluguel;

import org.example.entities.Pessoa;
import org.example.entities.Veiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class Aluguel {


    public void alugarVeiculo(Veiculo veiculo, Pessoa locador, LocalDateTime dataInicio) {

        veiculo.alugarVeiculo(locador, dataInicio);
        locador.associarVeiculo(veiculo);
    }

    public void alugarVeiculo(Veiculo veiculo, Pessoa locador) {

        LocalDateTime dataInicio = LocalDateTime.now();

        veiculo.alugarVeiculo(locador,dataInicio);
        locador.associarVeiculo(veiculo);
    }


    public Double devolverVeiculo(Veiculo veiculo, Pessoa locador, LocalDateTime dataFim) {
        Double valor = veiculo.calcularValor(dataFim);

        veiculo.devolverVeiculo();
        locador.desassociarVeiculo(veiculo);

        return valor;
    }


    public Double devolverVeiculo(Veiculo veiculo, Pessoa locador) {

        LocalDateTime dataFim = LocalDateTime.now();

        Double valor = veiculo.calcularValor(dataFim);

        veiculo.devolverVeiculo();
        locador.desassociarVeiculo(veiculo);

        return valor;
    }
}

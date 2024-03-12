package org.example.entities;

import java.time.LocalDateTime;

public class VeiculoPequeno extends Veiculo{
    public VeiculoPequeno(String placa, String marca, int ano, String cor) {
        super(placa, marca, ano, cor, "Pequeno");
    }

    @Override
    public Double calcularValor() {
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataInicio = getDataInicio();

        long dias = dataInicio.getDayOfYear() - dataAtual.getDayOfYear();


        return null;
    }
}

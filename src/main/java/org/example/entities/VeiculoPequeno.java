package org.example.entities;

import java.time.LocalDateTime;

public class VeiculoPequeno extends Veiculo{
    public VeiculoPequeno(String placa, String marca, int ano, String cor) {
        super(placa, marca, ano, cor, "Pequeno");
    }

    @Override
    public Double calcularValor(String dataFim) {
        String dataInicio = getDataInicio();


        //long dias = dataFim.getSecond() - dataInicio.getSecond();


        return 20.0;
    }
}

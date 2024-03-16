package org.example.entities;

import java.time.LocalDateTime;

public class VeiculoPequeno extends Veiculo{
    public VeiculoPequeno(String placa, String modelo, String marca, int ano, String cor) {
        super(placa, modelo, marca, ano, cor, "Pequeno");
    }

    public VeiculoPequeno(String placa,
                        String modelo ,
                        String marca,
                        int ano,
                        String cor,
                        String tipo,
                        Pessoa locador,
                        String dataInicio) {
        super(placa, modelo, marca, ano, cor, tipo, locador, dataInicio);
    }
    @Override
    public Double calcularValor(LocalDateTime dataFim) {
        //String dataInicio = getDataInicio();


        //long dias = dataFim.getSecond() - dataInicio.getSecond();


        return 20.0;
    }
}

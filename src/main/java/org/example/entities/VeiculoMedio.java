package org.example.entities;

import java.time.LocalDateTime;

public class VeiculoMedio extends Veiculo{

    public VeiculoMedio(String placa, String modelo, String marca, int ano, String cor) {
        super(placa, modelo, marca, ano, cor, "Medio");
    }

    public VeiculoMedio(String placa,
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
        return null;
    }
}

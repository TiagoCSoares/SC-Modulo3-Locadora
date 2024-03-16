package org.example.entities;

import java.time.LocalDateTime;

public class VeiculoSUV extends Veiculo{
    public VeiculoSUV(String placa, String modelo, String marca, int ano, String cor) {
        super(placa, modelo, marca, ano, cor, "SUV");
    }

    public VeiculoSUV(String placa,
                        String modelo ,
                        String marca,
                        int ano,
                        String cor,
                        String tipo,
                        Pessoa locador,
                        LocalDateTime dataInicio) {
        super(placa, modelo, marca, ano, cor, tipo, locador, dataInicio);
    }

    @Override
    public Double calcularValor(LocalDateTime dataFim) {
        return null;
    }
}

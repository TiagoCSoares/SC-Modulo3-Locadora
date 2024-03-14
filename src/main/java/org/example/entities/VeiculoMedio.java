package org.example.entities;

import java.time.LocalDateTime;

public class VeiculoMedio extends Veiculo{
    public VeiculoMedio(String placa, String modelo, String marca, int ano, String cor) {
        super(placa, modelo, marca, ano, cor, "Pequeno");
    }

    @Override
    public Double calcularValor(LocalDateTime dataFim) {
        return null;
    }
}

package org.example.view.veiculos;

import org.example.resources.verificadores.VerificarInt;
import org.example.services.VeiculoService;
import org.example.view.metodosAuxiliares.cadastrar.CadastrarVeiculo;

import javax.swing.text.View;
import java.util.Scanner;

public class CadastrarVeiculoView {
    private VeiculoService veiculoService;

    public CadastrarVeiculoView(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public void execute() {

        int option = -1;
        while (option < 0 || option > 2) {
            option = new VerificarInt().verificarInt("""
                    Qual o tipo do Veículo?:
                    1 - Pequeno
                    2 - Médio
                    3 - SUV
                    """);
        }

        new CadastrarVeiculo(veiculoService).cadastrarVeiculo(option);
    }


}

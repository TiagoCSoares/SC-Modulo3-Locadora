package org.example.view.veiculos;

import org.example.entities.Veiculo;
import org.example.services.VeiculoService;

import java.util.List;

public class ListarVeiculosView {

    private VeiculoService veiculoService;

    public ListarVeiculosView(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public void execute() {

        List<Veiculo> veiculosList = veiculoService.listar();

        if(!veiculosList.isEmpty()) {
            System.out.println(veiculosList.get(0).cabecalho());
            for (Veiculo veiculo : veiculosList) {
                System.out.println(veiculo.exibir());
            }
            System.out.println();
        } else {
            System.out.println("Nenhum veículo cadastrado");
        }
    }
}

package org.example.view.veiculos;

import org.example.entities.Veiculo;
import org.example.services.VeiculoService;

import java.util.Scanner;

public class BuscarVeiculoView {

    private VeiculoService veiculoService;

    public BuscarVeiculoView(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }



    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o modelo do carro:");
        String modelo = scanner.nextLine();

        Veiculo veiculo = veiculoService.pesquisarPorNome(modelo);
        if(veiculo != null)
            System.out.println(veiculo.exibir());
        else
            System.out.println("Veiculo não encontrado!");
    }
}

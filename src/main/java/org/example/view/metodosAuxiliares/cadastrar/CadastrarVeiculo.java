package org.example.view.metodosAuxiliares.cadastrar;

import org.example.entities.Veiculo;
import org.example.services.VeiculoService;

import java.util.Scanner;

public class CadastrarVeiculo {
    private VeiculoService veiculoService;

    public CadastrarVeiculo(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public void cadastrarVeiculo(String tipo) {
        Scanner scanner = new Scanner(System.in);

        String placa = veiculoService.definirIdentificador();

        System.out.println("Digite o modelo do Veículo:");
        String modelo = scanner.nextLine();

        System.out.println("Digite a marca do Veículo:");
        String marca = scanner.nextLine();

        System.out.println("Digite o ano do Veículo:");
        int ano = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite a cor do Veículo:");
        String cor = scanner.nextLine();

        Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, cor, tipo);
        veiculoService.criar(veiculo);
    }
}

package org.example.view.metodosAuxiliares.cadastrar;

import org.example.entities.VeiculoMedio;
import org.example.entities.VeiculoPequeno;
import org.example.entities.VeiculoSUV;
import org.example.services.VeiculoService;

import java.util.Scanner;

public class CadastrarVeiculo {
    private VeiculoService veiculoService;

    public CadastrarVeiculo(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public void cadastrarVeiculo(int option) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a placa do Veículo:");
        String placa = veiculoService.definirIdentificador();

        System.out.println("Digite o modelo do Veículo:");
        String modelo = scanner.nextLine();

        System.out.println("Digite a marca do Veículo:");
        String marca = scanner.nextLine();

        System.out.println("Digite o ano do Veículo:");
        int ano = scanner.nextInt();

        System.out.println("Digite a cor do Veículo:");
        String cor = scanner.nextLine();

        switch (option) {
            case 1:
                VeiculoPequeno veiculoPequeno = new VeiculoPequeno(
                        placa,
                        modelo,
                        marca,
                        ano,
                        cor);
                veiculoService.criar(veiculoPequeno);
                break;
            case 2:
                VeiculoMedio veiculoMedio = new VeiculoMedio(
                        placa,
                        modelo,
                        marca,
                        ano,
                        cor);
                veiculoService.criar(veiculoMedio);
                break;
            case 3:
                VeiculoSUV veiculoSUV = new VeiculoSUV(
                        placa,
                        modelo,
                        marca,
                        ano,
                        cor);
                veiculoService.criar(veiculoSUV);
                break;
        }

    }
}

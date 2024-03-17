package org.example.view.veiculos;

import org.example.entities.Veiculo;
import org.example.services.VeiculoService;

import java.util.Scanner;

public class AtualizarVeiculoView {

    private VeiculoService veiculoService;

    public AtualizarVeiculoView(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    protected Veiculo novosDadosVeiculo(Veiculo veiculo) {
        Scanner scanner = new Scanner(System.in);

        String placa = veiculo.getPlaca();
        System.out.println("Deseja atualizar a placa? (S/N):");
        char resposta = scanner.nextLine().charAt(0);
        resposta = Character.toUpperCase(resposta);
        if (resposta == 'S') {
            System.out.println("Digite a nova placa:");
            placa = scanner.nextLine();
        }

        String cor = veiculo.getCor();
        System.out.println("Deseja atualizar a placa? (S/N):");
        resposta = scanner.nextLine().charAt(0);
        resposta = Character.toUpperCase(resposta);
        if (resposta == 'S') {
            System.out.println("Digite a nova cor:");
            placa = scanner.nextLine();
        }

            Veiculo novoVeiculo = new Veiculo(placa,
                    veiculo.getModelo(),
                    veiculo.getTipo(),
                    veiculo.getAno(),
                    veiculo.getMarca(),
                    cor,
                    veiculo.getLocador(),
                    veiculo.getDataInicio()) {
            };
        return veiculo;
    }


    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o modelo do carro:");
        String modelo = scanner.nextLine();

        Veiculo veiculo = veiculoService.pesquisarPorNome(modelo);
        if(veiculo != null) {
            Veiculo novosDados = novosDadosVeiculo(veiculo);
            veiculoService.atualizar(veiculo, novosDados);
        } else
            System.out.println("Veiculo não encontrado!");

    }
}

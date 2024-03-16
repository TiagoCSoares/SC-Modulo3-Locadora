package org.example.view.veiculos;

import org.example.entities.Pessoa;
import org.example.entities.PessoaJuridica;
import org.example.entities.Veiculo;
import org.example.services.VeiculoService;

import java.util.Scanner;

public class ExcluirVeiculoView {

    private VeiculoService veiculoService;

    public ExcluirVeiculoView(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }


    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente que você deseja deletar:");
        String modelo = scanner.nextLine();
        Veiculo veiculo = veiculoService.pesquisarPorNome(modelo);
        if(veiculo != null) {
            Pessoa cliente = veiculo.getLocador();
            cliente.desassociarVeiculo(veiculo);
            veiculoService.excluir(veiculo);
        } else
            System.out.println("Cliente não encontrado");
    }
}

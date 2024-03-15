package org.example.view.cliente;

import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.entities.Veiculo;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;
import org.example.services.VeiculoService;

import java.util.Scanner;

public class ExcluirClienteView  implements ClienteInterface {

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;
    private VeiculoService veiculoService;

    public ExcluirClienteView(PessoaFisicaService pessoaFisicaService,
                              PessoaJuridicaService pessoaJuridicaService,
                              VeiculoService veiculoService) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
        this.veiculoService = veiculoService;
    }


    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int option = tipoPessoa();

        String nome;
        if(option == 1) {
            System.out.println("Digite o nome do cliente que você deseja deletar:");
            nome = scanner.nextLine();
            PessoaJuridica cliente = pessoaJuridicaService.pesquisarPorNome(nome);
            if(cliente != null) {
                for (Veiculo veiculo : cliente.getVeiculos())
                    veiculo.setLocador(null);
                pessoaJuridicaService.excluir(cliente);
            } else
                System.out.println("Cliente não encontrado");

        } else if(option == 2) {
            System.out.println("Digite o nome do cliente:");
            nome = scanner.nextLine();
            PessoaFisica cliente = pessoaFisicaService.pesquisarPorNome(nome);
            if(cliente != null) {
                for (Veiculo veiculo : cliente.getVeiculos())
                    veiculo.setLocador(null);
                pessoaFisicaService.excluir(cliente);
            } else
                System.out.println("Cliente não encontrado");
        } else if (option == 0) {
            System.out.println("Operação cancelada");
        }
    }
}

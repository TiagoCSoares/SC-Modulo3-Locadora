package org.example.view.cliente;

import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.resources.cadastrar.CadastrarPessoaFisica;
import org.example.resources.cadastrar.CadastrarPessoaJuridica;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;

import java.util.Scanner;

public class ExcluirClienteView  implements ClienteInterface {

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;
    //private VeiculoService veiculoService;

    public ExcluirClienteView(PessoaFisicaService pessoaFisicaService, PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
        //this.veiculoService = veiculoService;
    }


    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int option = tipoPessoa();

        String nome;
        if(option == 1) {
            System.out.println("Digite o nome do cliente que você deseja deletar:");
            nome = scanner.nextLine();
            PessoaJuridica cliente = pessoaJuridicaService.pesquisarPorNome(nome);
            if(cliente != null)
                pessoaJuridicaService.excluir(cliente);
            else
                System.out.println("Cliente não encontrado");

        } else if(option == 2) {
            System.out.println("Digite o nome do cliente:");
            nome = scanner.nextLine();
            PessoaFisica cliente = pessoaFisicaService.pesquisarPorNome(nome);
            if(cliente != null)
                pessoaFisicaService.excluir(cliente);
            else
                System.out.println("Cliente não encontrado");
        } else if (option == 0) {
            System.out.println("Operação cancelada");
        }
    }
}

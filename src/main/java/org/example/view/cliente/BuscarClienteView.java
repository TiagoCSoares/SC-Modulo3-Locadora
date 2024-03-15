package org.example.view.cliente;


import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.resources.verificadores.VerificarInt;
import org.example.resources.verificadores.VerificarLong;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;

import java.util.Scanner;

public class BuscarClienteView implements ClienteInterface{

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;

    public BuscarClienteView(PessoaFisicaService pessoaFisicaService, PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
    }


    public void execute() {
        Scanner scanner = new Scanner(System.in);

        int option = tipoPessoa();

        String nome;
        if(option == 1) {
            System.out.println("Digite o nome do cliente:");
            nome = scanner.nextLine();
            PessoaJuridica cliente = pessoaJuridicaService.pesquisarPorNome(nome);
            if(cliente != null)
                System.out.println(cliente.exibir());
            else
                System.out.println("Cliente não encontrado");
        } else if(option == 2) {
            System.out.println("Digite o nome do cliente:");
            nome = scanner.nextLine();
            PessoaFisica cliente = pessoaFisicaService.pesquisarPorNome(nome);
            if(cliente != null)
                System.out.println(cliente.exibir());
            else
                System.out.println("Cliente não encontrado");
        } else if (option == 0) {
            System.out.println("Operação cancelada");
        }
    }
}

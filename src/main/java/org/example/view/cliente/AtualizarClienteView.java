package org.example.view.cliente;

import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.entities.Veiculo;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;

import java.util.List;
import java.util.Scanner;

public class AtualizarClienteView implements ClienteInterface {

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;


    public AtualizarClienteView(PessoaFisicaService pessoaFisicaService, PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
    }


    public PessoaFisica novosDadosPessoaFisica(PessoaFisica cliente) {
        Scanner scanner = new Scanner(System.in);

        String nome = cliente.getNome();
        System.out.println("Deseja atualizar o nome? (S/N):");
        char resposta = scanner.nextLine().charAt(0);
        resposta = Character.toUpperCase(resposta);
        if (resposta == 'S') {
            System.out.println("Digite o novo nome:");
            nome = scanner.nextLine();
        }

        String endereco = cliente.getEndereco();
        System.out.println("Deseja atualizar o endereco? (S/N):");
        resposta = scanner.nextLine().charAt(0);
        resposta = Character.toUpperCase(resposta);
        if (resposta == 'S') {
            System.out.println("Digite o novo endereco:");
            endereco = scanner.nextLine();
        }

        String dataNascimento = cliente.getDataNascimento();
        System.out.println("Deseja atualizar a data de nascimento? (S/N):");
        resposta = scanner.nextLine().charAt(0);
        resposta = Character.toUpperCase(resposta);
        if (resposta == 'S') {
            System.out.println("Digite a nova data:");
            dataNascimento = scanner.nextLine();
            dataNascimento = pessoaFisicaService.verificarDataNascimento(dataNascimento);
        }

        long cpf = cliente.getCpf();
        List<Veiculo> veiculos = cliente.getVeiculos();

        PessoaFisica pessoa = new PessoaFisica(cpf, nome, endereco, dataNascimento,veiculos);

        return pessoa;
    }





    public PessoaJuridica novosDadosPessoaJuridica(PessoaJuridica cliente) {
        Scanner scanner = new Scanner(System.in);

        String nome = cliente.getNome();
        System.out.println("Deseja atualizar o nome? (S/N):");
        char resposta = scanner.nextLine().charAt(0);
        resposta = Character.toUpperCase(resposta);
        if (resposta == 'S') {
            System.out.println("Digite o novo nome:");
            nome = scanner.nextLine();
        }

        String endereco = cliente.getEndereco();
        System.out.println("Deseja atualizar o endereco? (S/N):");
        resposta = scanner.nextLine().charAt(0);
        resposta = Character.toUpperCase(resposta);
        if (resposta == 'S') {
            System.out.println("Digite o novo endereco:");
            endereco = scanner.nextLine();
        }

        long cnpj = cliente.getCnpj();
        List<Veiculo> veiculos = cliente.getVeiculos();

        PessoaJuridica pessoa = new PessoaJuridica(cnpj, nome, endereco, veiculos);

        return pessoa;
    }









    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int option = tipoPessoa();

        String nome;
        if(option == 1) {
            System.out.println("Digite o nome do cliente que você deseja atualizar:");
            nome = scanner.nextLine();
            PessoaJuridica cliente = pessoaJuridicaService.pesquisarPorNome(nome);
            if(cliente != null) {
                PessoaJuridica novosDados = novosDadosPessoaJuridica(cliente);
                pessoaJuridicaService.atualizar(cliente, novosDados);
            }

        } else if(option == 2) {
            System.out.println("Digite o nome do cliente:");
            nome = scanner.nextLine();
            PessoaFisica cliente = pessoaFisicaService.pesquisarPorNome(nome);
            if (cliente != null) {
                PessoaFisica novosDados = novosDadosPessoaFisica(cliente);
                pessoaFisicaService.atualizar(cliente, novosDados);
            }

        } else if (option == 0) {
            System.out.println("Operação cancelada");

        } else {
            System.out.println("Cliente não encontrado");
        }
    }

    }

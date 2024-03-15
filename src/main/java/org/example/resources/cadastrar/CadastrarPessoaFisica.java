package org.example.resources.cadastrar;

import org.example.entities.PessoaFisica;
import org.example.services.PessoaFisicaService;

import java.util.Scanner;

public class CadastrarPessoaFisica implements CadastrarCliente{

    private PessoaFisicaService pessoaFisicaService;

    public CadastrarPessoaFisica(PessoaFisicaService pessoaFisicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
    }

    @Override
    public void cadastrarCliente() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        long cpf = pessoaFisicaService.definirIdentificador();

        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();

        System.out.println("Digite a data de nascimento do artista (DD/MM/YYYY):");
        String dataNascimento = scanner.nextLine();
        dataNascimento = pessoaFisicaService.verificarDataNascimento(dataNascimento);

        PessoaFisica pessoa = new PessoaFisica(cpf, nome, endereco, dataNascimento,null);
        pessoaFisicaService.criar(pessoa);
    }
}

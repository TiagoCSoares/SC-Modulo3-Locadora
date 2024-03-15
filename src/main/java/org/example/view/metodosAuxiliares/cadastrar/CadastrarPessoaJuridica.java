package org.example.view.metodosAuxiliares.cadastrar;

import org.example.entities.PessoaJuridica;
import org.example.services.PessoaJuridicaService;

import java.util.Scanner;

public class CadastrarPessoaJuridica implements CadastrarCliente{

    private PessoaJuridicaService pessoaJuridicaService;

    public CadastrarPessoaJuridica(PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaJuridicaService = pessoaJuridicaService;
    }

    @Override
    public void cadastrarCliente() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o CNPJ (Apenas Digitos):");
        Long cnpj = pessoaJuridicaService.definirIdentificador();

        PessoaJuridica pessoa = new PessoaJuridica(cnpj, nome, endereco, null);
        pessoaJuridicaService.criar(pessoa);
    }
}

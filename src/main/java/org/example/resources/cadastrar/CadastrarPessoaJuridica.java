package org.example.resources.cadastrar;

import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;

import java.util.Scanner;

public class CadastrarPessoaJuridica implements CadastrarCliente{
    @Override
    public void cadastrarCliente() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o CNPJ (Apenas Digitos):");
        Long cnpj = scanner.nextLong();

        Pessoa pessoa = new PessoaJuridica(cnpj, nome, endereco, null);
        // TODO: Adicionar no banco de dados

    }
}

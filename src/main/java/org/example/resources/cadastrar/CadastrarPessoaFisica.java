package org.example.resources.cadastrar;

import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;

import java.util.Scanner;

public class CadastrarPessoaFisica implements CadastrarCliente{
    @Override
    public void cadastrarCliente() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o CPF (Apenas Digitos):");
        Long cpf = scanner.nextLong();

        System.out.println("Digite a data de nascimento:");
        String dataNascimento = scanner.nextLine();

        Pessoa pessoa = new PessoaFisica(cpf, nome, endereco, dataNascimento);
    }
}

package org.example.view.cliente;

import org.example.resources.cadastrar.CadastrarPessoaFisica;

import java.util.Scanner;

public class CadastrarClienteView {


    public void execute() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("O cliente é:");
            System.out.println("1 - Pessoa Jurídica" +
                    "\n2 - Pessoa Física");
            int option = scanner.nextInt();

            if(option == 1) {
                CadastrarPessoaFisica cadastrarPessoaFisica = new CadastrarPessoaFisica();
            }
        }
    }

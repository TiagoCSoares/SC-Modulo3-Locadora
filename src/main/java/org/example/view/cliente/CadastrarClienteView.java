package org.example.view.cliente;

import org.example.resources.cadastrar.CadastrarPessoaFisica;
import org.example.resources.cadastrar.CadastrarPessoaJuridica;
import org.example.resources.verificadores.VerificarInt;
import org.example.services.PessoaFisicaService;

import java.util.Scanner;

public class CadastrarClienteView {

    private PessoaFisicaService pessoaFisicaService;

    public CadastrarClienteView(PessoaFisicaService pessoaFisicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
    }

    public void execute() {
            int option = -1;
            while(option < 0  || option > 2) {
                option = new VerificarInt().verificarInt("""
                        O cliente é:
                        1 - Pessoa Jurídica
                        2 - Pessoa Física
                        0 - Cancelar operação
                        """);
            }

            if(option == 1) {
                CadastrarPessoaJuridica cadastro = new CadastrarPessoaJuridica();
                cadastro.cadastrarCliente();
            } else if(option == 2) {
                CadastrarPessoaFisica cadastro = new CadastrarPessoaFisica(pessoaFisicaService);
                cadastro.cadastrarCliente();
                System.out.println("cadastrou vadia");
            }
        }
    }

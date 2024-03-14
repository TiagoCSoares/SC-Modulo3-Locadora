package org.example.view.cliente;

import org.example.resources.cadastrar.CadastrarPessoaFisica;
import org.example.resources.cadastrar.CadastrarPessoaJuridica;
import org.example.resources.verificadores.VerificarInt;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;

import java.util.Scanner;

public class CadastrarClienteView {

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;


    public CadastrarClienteView(PessoaFisicaService pessoaFisicaService, PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
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
                CadastrarPessoaJuridica cadastro = new CadastrarPessoaJuridica(pessoaJuridicaService);
                cadastro.cadastrarCliente();
            } else if(option == 2) {
                CadastrarPessoaFisica cadastro = new CadastrarPessoaFisica(pessoaFisicaService);
                cadastro.cadastrarCliente();
            }
        }
    }

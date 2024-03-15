package org.example.view.cliente;

import org.example.view.metodosAuxiliares.cadastrar.CadastrarPessoaFisica;
import org.example.view.metodosAuxiliares.cadastrar.CadastrarPessoaJuridica;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;

public class CadastrarClienteView implements ClienteInterface{

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;


    public CadastrarClienteView(PessoaFisicaService pessoaFisicaService, PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
    }


    public void execute() {
            int option = tipoPessoa();

            if(option == 1) {
                CadastrarPessoaJuridica cadastro = new CadastrarPessoaJuridica(pessoaJuridicaService);
                cadastro.cadastrarCliente();
            } else if(option == 2) {
                CadastrarPessoaFisica cadastro = new CadastrarPessoaFisica(pessoaFisicaService);
                cadastro.cadastrarCliente();
            } else {
                System.out.println("Operação cancelada");
            }
        }
    }

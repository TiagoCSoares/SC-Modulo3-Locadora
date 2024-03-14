package org.example.view.cliente;

import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;

public class AtualizarClienteView {

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;


    public AtualizarClienteView(PessoaFisicaService pessoaFisicaService, PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
    }

    public void execute() {

    }
}

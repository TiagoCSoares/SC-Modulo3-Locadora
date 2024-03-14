package org.example.view.cliente;


import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.resources.verificadores.VerificarInt;
import org.example.resources.verificadores.VerificarLong;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;

public class BuscarClienteView {

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;

    public BuscarClienteView(PessoaFisicaService pessoaFisicaService, PessoaJuridicaService pessoaJuridicaService) {
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

        Long id = 0L;

        if(option == 1) {
            id = new VerificarLong().verificarLong("""
                    Digite o cpf do cliente (Apenas digitos):
                    """);
        } else if(option == 2) {
            id = new VerificarLong().verificarLong("""
                    Digite o cnpj do cliente (Apenas digitos):
                    """);
        }
    }




}

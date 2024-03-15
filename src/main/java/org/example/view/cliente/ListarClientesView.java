package org.example.view.cliente;

import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.resources.verificadores.VerificarInt;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;

import java.util.List;

public class ListarClientesView implements ClienteInterface {

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;


    public ListarClientesView(PessoaFisicaService pessoaFisicaService, PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
    }

    public void execute() {

       int option = tipoPessoa();
        /*while(option < 0  || option > 3) {
            option = new VerificarInt().verificarInt("""
                        Listar:
                        1 - Pessoas Jurídicas
                        2 - Pessoas Físicas
                        //3 - Todos os clientes
                        0 - Cancelar operação
                        """);
        }*/



        List<PessoaJuridica> clientesJuridicos = pessoaJuridicaService.listar();
        List<PessoaFisica> clientesFisicos = pessoaFisicaService.listar();

        switch (option) {
            case 1:
                if(!clientesJuridicos.isEmpty()) {
                    System.out.println(clientesJuridicos.get(0).cabecalho());
                    for (PessoaJuridica cliente : clientesJuridicos) {
                        System.out.println(cliente.exibir());
                    }
                    System.out.println();
                } else {
                    System.out.println("Nenhum cliente cadastrado");
                }
                break;

            case 2:
                if (!clientesFisicos.isEmpty()) {
                    System.out.println(clientesFisicos.get(0).cabecalho());
                    for (PessoaFisica cliente : clientesFisicos) {
                        System.out.println(cliente.exibir());
                    }
                    System.out.println();
                } else {
                    System.out.println("Nenhum cliente cadastrado");
                }
                break;
            case 0:
                System.out.println("Cancelando!");
        }
    }


    }

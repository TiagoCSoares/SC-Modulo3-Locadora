package org.example.view.cliente;

import org.example.entities.PessoaFisica;
import org.example.resources.verificadores.VerificarInt;
import org.example.services.PessoaFisicaService;

import java.util.List;

public class ListarClientesView {

    private PessoaFisicaService pessoaFisicaService;

    public ListarClientesView(PessoaFisicaService pessoaFisicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
    }

    public void execute() {

       /* int option = -1;
        while(option < 0  || option > 3) {
            option = new VerificarInt().verificarInt("""
                        Listar:
                        1 - Pessoas Jurídicas
                        2 - Pessoas Físicas
                        3 - Todos os clientes
                        0 - Cancelar operação
                        """);
        }
*/
        List<PessoaFisica> clientesFisicos = pessoaFisicaService.listar();

        System.out.println("Clientes cadastrados:");
        for (PessoaFisica cliente : clientesFisicos) {
            System.out.println(cliente.getNome());
        }
        if (!clientesFisicos.isEmpty()) {
            System.out.println("Clientes cadastrados:");
            for (PessoaFisica cliente : clientesFisicos) {
                System.out.println(cliente.getNome());
            }
        } else {
            System.out.println("Nenhum artista cadastrado");
        }
    }


    }

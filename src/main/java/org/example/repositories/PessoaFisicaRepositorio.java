package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.entities.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepositorio extends AbstractRepositorio {
    public PessoaFisicaRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return PessoaFisica.class;
    }

    @Override
    protected <T> Boolean filtraPorId(Object objeto, T id) {
        PessoaFisica pessoaFisica = (PessoaFisica) objeto;
        return pessoaFisica.getCpf().equals(id);
    }

    @Override
    public List<PessoaFisica> buscarPorNome(String nome) {
        nome = nome.toLowerCase();

        List<PessoaFisica> clientes = listar();
        List<PessoaFisica> clientesEncontrados = new ArrayList<>();

        if (clientes != null) {
            for (PessoaFisica cliente : clientes) {
                if (cliente.getNome().toLowerCase().contains(nome)) {
                    clientesEncontrados.add(cliente);
                }
            }
        }
        if (clientesEncontrados.isEmpty()) {
            return null;
        }
        return clientesEncontrados;
    }

    @Override
    public void gravar(Object objeto) {
        PessoaFisica cliente = (PessoaFisica) objeto;
        /*if (cliente.getId() == null) {
            cliente.setId(bancoDeDados.proximoId());
        }*/
        super.gravar(objeto);
    }

}

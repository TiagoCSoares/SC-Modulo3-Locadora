package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.entities.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepositorio extends AbstractRepositorio {
    public PessoaJuridicaRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return PessoaFisica.class;
    }

    @Override
    protected <T> Boolean filtraPorId(Object objeto, T id) {
        PessoaJuridica pessoaJuridica = (PessoaJuridica) objeto;
        return pessoaJuridica.getCnpj().equals(id);
    }


    @Override
    public List<PessoaJuridica> buscarPorNome(String nome) {
        nome = nome.toLowerCase();
        List<PessoaJuridica> clientesEncontrados = new ArrayList<>();

        if (clientesEncontrados != null) {
            for (PessoaJuridica cliente : clientesEncontrados) {
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
        PessoaJuridica cliente = (PessoaJuridica) objeto;
        if (cliente.getId() == null) {
            cliente.setId(bancoDeDados.proximoId());
        }
        super.gravar(objeto);
        System.out.println(listar());
    }
}

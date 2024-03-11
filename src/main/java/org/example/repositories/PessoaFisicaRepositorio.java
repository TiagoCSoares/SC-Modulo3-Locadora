package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.entities.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepositorio extends AbstractRepositorio{
    public PessoaFisicaRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return null;
    }

    @Override
    protected Boolean filtraPorId(Object objeto, Long id) {
        PessoaFisica pessoaFisica = (PessoaFisica) objeto;
        return pessoaFisica.getId().equals(id);
    }

    @Override
    public List<PessoaFisica> buscarPorNome(String nome) {
        nome = nome.toLowerCase();
        List<PessoaFisica> clientesEncontrados = new ArrayList<>();

        if(clientesEncontrados != null) {
            for (PessoaFisica cliente : clientesEncontrados) {
                if (cliente.getNome().toLowerCase().contains(nome)) {
                    clientesEncontrados.add(cliente);
                }
            }
        }
        if(clientesEncontrados.isEmpty()) {
            return null;
        }
        return clientesEncontrados;
    }

    @Override
    public <T extends Veiculo> void associarVeiculo(Pessoa pessoa, T veiculo) {
        PessoaFisica cliente = (PessoaFisica) pessoa;
        cliente.associarVeiculo(veiculo);
    }

    @Override
    public <T extends Veiculo> void excluirVeiculo(T veiculo) {

    }
}

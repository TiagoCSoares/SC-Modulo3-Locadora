package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.entities.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepositorio extends AbstractRepositorio {
    public VeiculoRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }

    @Override
    protected Class classeModelo() {
        return Veiculo.class;
    }



    @Override
    protected <T> Boolean filtraPorId(Object objeto, T id) {
        Veiculo veiculo = (Veiculo) objeto;
        return veiculo.getPlaca().equals(id);
    }


    @Override
    public List<Veiculo> buscarPorNome(String nome) {
        nome = nome.toLowerCase();
        List<Veiculo> veiculosEncontrados = new ArrayList<>();

        if (veiculosEncontrados != null) {
            for (Veiculo veiculo : veiculosEncontrados) {
                if (veiculo.getModelo().toLowerCase().contains(nome)) {
                    veiculosEncontrados.add(veiculo);
                }
            }
        }
        if (veiculosEncontrados.isEmpty()) {
            return null;
        }
        return veiculosEncontrados;
    }


    @Override
    public void gravar(Object objeto) {
        Veiculo veiculo = (Veiculo) objeto;
        super.gravar(objeto);
        System.out.println(listar());
    }
}

package org.example.repositories;

import org.example.banco.BancoDeDados;
import org.example.entities.Pessoa;
import org.example.entities.Veiculo;


import java.util.Collections;
import java.util.List;

public abstract class AbstractRepositorio {

    protected BancoDeDados bancoDeDados;

    public AbstractRepositorio(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public void gravar(Object objeto) {
        this.bancoDeDados.inserirObjeto(objeto);
    }

    public Object buscarPorId(Long id) {
        List objetos = listar();
        Object encontradoPorId = null;
        for (Object objeto : objetos) {
            if (filtraPorId(objeto, id)) {
                encontradoPorId = objeto;
            }
        }
        return encontradoPorId;
    }

    public List listar() {
        List objetosPresentesNoBanco = this.bancoDeDados.buscarObjetosPorTipo(classeModelo());
        return Collections.unmodifiableList(objetosPresentesNoBanco);
    }

    public Boolean excluir(Object objeto) {
        this.bancoDeDados.excluirObjeto(objeto);
        return true;
    }

    protected abstract Class classeModelo();

    protected abstract Boolean filtraPorId(Object objeto, Long id);

    public abstract List buscarPorNome(String nome);

    public abstract <T extends Veiculo> void associarVeiculo(Pessoa pessoa, T veiculo);

    public abstract <T extends Veiculo> void excluirVeiculo(T veiculo);


}
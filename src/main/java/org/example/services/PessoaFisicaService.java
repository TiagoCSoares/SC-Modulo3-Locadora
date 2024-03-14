package org.example.services;

import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.repositories.PessoaFisicaRepositorio;
import org.example.resources.escreverArquivos.EscreverArquivos;

import java.util.List;

public class PessoaFisicaService implements ServiceInterface{

    private PessoaFisicaRepositorio pessoaFisicaRepositorio;

    public PessoaFisicaService(PessoaFisicaRepositorio pessoaFisicaRepositorio) {
        this.pessoaFisicaRepositorio = pessoaFisicaRepositorio;
    }

    public void criar(PessoaFisica pessoa) {
        if(pessoa == null) {
            throw new IllegalArgumentException("Artista não pode ser nulo");
        }
        if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do artista não pode ser nulo ou vazio");
        }
        pessoaFisicaRepositorio.gravar(pessoa);
    }



    public void excluir(PessoaFisica pessoa) {
        if(pessoa == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if(pessoa.getCpf() == null) {
            throw new IllegalArgumentException("Cpf do cliente não pode ser nulo");
        }
        Pessoa pessoaSalva = (Pessoa) pessoaFisicaRepositorio.buscarPorId(pessoa.getCpf());
        if(pessoaSalva == null) {
            throw new IllegalArgumentException("Artista não encontrado");
        }
        pessoaFisicaRepositorio.excluir(pessoa);
    }


    public void escreverArquivo() {
        List<PessoaFisica> clientes = listar();
        new EscreverArquivos().escreverDados(
                caminhoDoArquivo(), clientes);
    }


    public List listar() {
        return pessoaFisicaRepositorio.listar();
    }

    public List<PessoaFisica> pesquisarPorNome(String nome) {
        List<PessoaFisica> clientes = null;
        if(nome != null) {
            clientes = pessoaFisicaRepositorio.buscarPorNome(nome);
        }
        return clientes;
    }

    @Override
    public String caminhoDoArquivo() {
        return "src/main/java/org/example/arquivos/pessoasFisicas.txt";
    }
}

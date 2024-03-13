package org.example.services;

import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.repositories.PessoaFisicaRepositorio;
import org.example.repositories.PessoaJuridicaRepositorio;

import java.util.List;

public class PessoaJuridicaService {

    private PessoaJuridicaRepositorio pessoaJuridicaRepositorio;

    public PessoaJuridicaService(PessoaJuridicaRepositorio pessoaJuridicaRepositorio) {
        this.pessoaJuridicaRepositorio = pessoaJuridicaRepositorio;
    }

    public void criar(PessoaJuridica pessoa) {
        if(pessoa == null) {
            throw new IllegalArgumentException("Artista não pode ser nulo");
        }
        if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do artista não pode ser nulo ou vazio");
        }
        pessoaJuridicaRepositorio.gravar(pessoa);
        System.out.println("gravou gilh o da puta");
        System.out.println(pessoaJuridicaRepositorio.listar());
    }



    public void excluir(PessoaJuridica pessoa) {
        if(pessoa == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if(pessoa.getCnpj() == null) {
            throw new IllegalArgumentException("Cpf do cliente não pode ser nulo");
        }
        Pessoa pessoaSalva = (Pessoa) pessoaJuridicaRepositorio.buscarPorId(pessoa.getCnpj());
        if(pessoaSalva == null) {
            throw new IllegalArgumentException("Artista não encontrado");
        }
        pessoaJuridicaRepositorio.excluir(pessoa);
    }


    public void escreverArquivo() {
        List<PessoaJuridicaRepositorio> clientes = listar();
        //EscreverArquivos escrever = new EscreverArquivos();
        //escrever.escreverArtistas(clientes);
    }


    public List listar() {
        return pessoaJuridicaRepositorio.listar();
    }

    public List<PessoaJuridica> pesquisarPorNome(String nome) {
        List<PessoaJuridica> clientes = null;
        if(nome != null) {
            clientes = pessoaJuridicaRepositorio.buscarPorNome(nome);
        }
        return clientes;
    }
}

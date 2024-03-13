package org.example;

import org.example.banco.BancoDeDados;
import org.example.entities.PessoaFisica;
import org.example.entities.VeiculoPequeno;
import org.example.repositories.PessoaFisicaRepositorio;
import org.example.resources.aluguel.Aluguel;
import org.example.resources.cadastrar.CadastrarPessoaFisica;
import org.example.services.PessoaFisicaService;
import org.example.view.Menu;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BancoDeDados bancoDeDadosPessoaFisica = new BancoDeDados();
        //BancoDeDados bancoDeDadosPessoaJuridica = new BancoDeDados();
        //BancoDeDados bancoDeDadosVeiculo = new BancoDeDados();

        PessoaFisicaRepositorio pessoaFisicaRepositorio = new PessoaFisicaRepositorio(bancoDeDadosPessoaFisica);
        //PessoaJuridicaRepositorio pessoaJuridicaRepositorio = new PessoaJuridicaRepositorio(bancoDeDadosPessoaJuridica);
        //VeiculoRepositorio veiculoRepositorio = new VeiculoRepositorio(bancoDeDadosVeiculo);

        PessoaFisicaService pessoaFisicaService = new PessoaFisicaService(pessoaFisicaRepositorio);


        Menu menuPrincipal = new Menu(pessoaFisicaService);
        menuPrincipal.execute();
    }
}
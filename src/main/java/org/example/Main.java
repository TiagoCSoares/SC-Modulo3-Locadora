package org.example;

import org.example.banco.BancoDeDados;
import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.entities.VeiculoPequeno;
import org.example.repositories.PessoaFisicaRepositorio;
import org.example.repositories.PessoaJuridicaRepositorio;
import org.example.resources.aluguel.Aluguel;
import org.example.resources.cadastrar.CadastrarPessoaFisica;
import org.example.resources.iniciarArquivos.IniciarArquivos;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;
import org.example.view.Menu;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BancoDeDados bancoDeDadosPessoaFisica = new BancoDeDados();
        BancoDeDados bancoDeDadosPessoaJuridica = new BancoDeDados();
        //BancoDeDados bancoDeDadosVeiculo = new BancoDeDados();

        PessoaFisicaRepositorio pessoaFisicaRepositorio = new PessoaFisicaRepositorio(bancoDeDadosPessoaFisica);
        PessoaFisicaService pessoaFisicaService = new PessoaFisicaService(pessoaFisicaRepositorio);

        PessoaJuridicaRepositorio pessoaJuridicaRepositorio = new PessoaJuridicaRepositorio(bancoDeDadosPessoaJuridica);
        PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService(pessoaJuridicaRepositorio);

        //VeiculoRepositorio veiculoRepositorio = new VeiculoRepositorio(bancoDeDadosVeiculo);

        new IniciarArquivos().iniciarArquivos();

        Menu menuPrincipal = new Menu(pessoaFisicaService, pessoaJuridicaService);
        menuPrincipal.execute();
    }
}
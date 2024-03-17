package org.example;

import org.example.banco.BancoDeDados;
import org.example.repositories.PessoaFisicaRepositorio;
import org.example.repositories.PessoaJuridicaRepositorio;
import org.example.repositories.VeiculoRepositorio;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;
import org.example.services.VeiculoService;
import org.example.view.Menu;


public class Main {
    public static void main(String[] args) {

        BancoDeDados bancoDeDadosPessoaFisica = new BancoDeDados();
        BancoDeDados bancoDeDadosPessoaJuridica = new BancoDeDados();
        BancoDeDados bancoDeDadosVeiculoPequenos = new BancoDeDados();

        PessoaFisicaRepositorio pessoaFisicaRepositorio = new PessoaFisicaRepositorio(bancoDeDadosPessoaFisica);
        PessoaFisicaService pessoaFisicaService = new PessoaFisicaService(pessoaFisicaRepositorio);

        PessoaJuridicaRepositorio pessoaJuridicaRepositorio = new PessoaJuridicaRepositorio(bancoDeDadosPessoaJuridica);
        PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService(pessoaJuridicaRepositorio);

        VeiculoRepositorio veiculoPequenoRepositorio = new VeiculoRepositorio(bancoDeDadosVeiculoPequenos);
        VeiculoService veiculoPequenoService = new VeiculoService(veiculoPequenoRepositorio);

        Menu menuPrincipal = new Menu(pessoaFisicaService, pessoaJuridicaService, veiculoPequenoService);
        menuPrincipal.execute();

    }
}
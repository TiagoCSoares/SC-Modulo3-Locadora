package org.example.services;


import org.example.entities.Veiculo;
import org.example.repositories.VeiculoRepositorio;
import org.example.resources.escreverArquivos.EscreverArquivos;

import java.util.List;
import java.util.Scanner;

public class VeiculoService implements ServiceInterface{

    private VeiculoRepositorio veiculoRepositorio;

    public VeiculoService(VeiculoRepositorio veiculoRepositorio) {
        this.veiculoRepositorio = veiculoRepositorio;
    }

    @Override
    public <T> void criar(T objeto) {
        Veiculo veiculo = (Veiculo) objeto;
        if(veiculo == null) {
            throw new IllegalArgumentException("Veiculo não pode ser nulo");
        }
        if (veiculo.getModelo() == null || veiculo.getModelo().trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo do veiculo não pode ser nulo ou vazio");
        }
        veiculoRepositorio.gravar(veiculo);
    }



    @Override
    public <T> void excluir(T objeto) {

        Veiculo veiculo = (Veiculo) objeto;

        if(veiculo == null) {
            throw new IllegalArgumentException("Veiculo não pode ser nulo");
        }
        if(veiculo.getPlaca() == null) {
            throw new IllegalArgumentException("Placa do veiculo não pode ser nulo");
        }
        Veiculo veiculoSalvo = (Veiculo) veiculoRepositorio.buscarPorId(veiculo.getPlaca());
        if(veiculoSalvo == null) {
            throw new IllegalArgumentException("Veiculo não encontrado");
        }
        veiculoRepositorio.excluir(veiculo);
    }


    @Override
    public void escreverArquivo() {
        List<Veiculo> veiculos = listar();
        new EscreverArquivos().escreverDados(
                caminhoDoArquivo(), veiculos);
    }


    @Override
    public List listar() {
        return veiculoRepositorio.listar();
    }

    @Override
    public <T> T entitieEncontrada(List<T> listaEntities) {
        Scanner scanner = new Scanner(System.in);

        Veiculo veiculoEncontrado;
        List<Veiculo> listaVeiculos = (List<Veiculo>) listaEntities;

        if(listaVeiculos != null && !listaVeiculos.isEmpty()) {
            for(Veiculo veiculo : listaVeiculos) {
                System.out.printf("%-14s | %-20s\n",
                        "CNPJ" , "Nome");
                System.out.println(veiculo.getPlaca() + " | "
                + veiculo.getModelo());
                System.out.println("Esse é o veiculo desejado?");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    veiculoEncontrado = veiculo;
                    return (T) veiculoEncontrado;
                }
            }
        }
        return null;
    }


    public void atualizar(Veiculo veiculo, Veiculo novosDados) {
        veiculo.setCor(novosDados.getCor());
        veiculo.setPlaca(novosDados.getPlaca());
    }

    @Override
    public <T> T pesquisarPorNome(String nome) {
        List<Veiculo> veiculos = null;
        Veiculo veiculo = null;

        if(nome != null) {
            veiculos = veiculoRepositorio.buscarPorNome(nome);
            veiculo = entitieEncontrada(veiculos);
        }

        return (T) veiculo;
    }

    @Override
    public String caminhoDoArquivo() {
        return "src/main/java/org/example/arquivos/veiculos.txt";
    }


    @Override
    public <T> T definirIdentificador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a placa do Veículo:");
        String placa = scanner.nextLine();

        while (!verificarIdentificador(String.valueOf(placa))){
            System.out.println("Placa inválida. Digite novamente:");
            placa = scanner.nextLine();
        }

        return (T) (placa);
    }


    @Override
    public Boolean verificarIdentificador(String placa) {
        return (placa.length() == 7);
    }

}

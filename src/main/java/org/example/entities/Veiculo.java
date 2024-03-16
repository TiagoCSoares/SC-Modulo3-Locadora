package org.example.entities;

import org.example.resources.escreverArquivos.Exibir;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Veiculo implements Exibir {
    private String placa;
    private final String modelo;
    private final String tipo;
    private final String marca;
    private final int ano;
    private String cor;
    private Pessoa locador;
    private LocalDateTime dataInicio;


    public Veiculo(String placa, String modelo ,String marca, int ano, String cor, String tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.tipo = tipo;
    }

    public Veiculo(String placa,
                   String modelo ,
                   String marca,
                   int ano,
                   String cor,
                   String tipo,
                   Pessoa locador,
                   LocalDateTime dataInicio) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.tipo = tipo;
        this.locador = locador;
        this.dataInicio = dataInicio;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }


    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Pessoa getLocador() {
        return locador;
    }

    public void setLocador(Pessoa locador) {
        this.locador = locador;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }


    public void alugarVeiculo(Pessoa locador, LocalDateTime dataInicio) {
        this.locador = locador;
        this.dataInicio = dataInicio;
    }

    public void devolverVeiculo() {
        this.locador = null;
        this.dataInicio = null;
    }


    public abstract Double calcularValor(LocalDateTime dataFim);





    public String cabecalho() {
        StringBuilder cabecalho = new StringBuilder();


        cabecalho.append(String.format("\n%-14s | %-20s | %-20s | %-5s\t | %-7s - %-15s - %-7s",
                "CPF", "Nome",
                "Endereço", "Idade",
                "Placa", "Modelo", "Tipo"));

        cabecalho.append(String.format("%-68s | %-20s",
                "Cliente", "Veiculo alugado"));


        return cabecalho.toString();
    }


    public String exibir() {
        StringBuilder cliente = new StringBuilder();
        cliente.append("teste");
        /*cliente.append(String.format(("%-14d | %-20s | %-20s | %-10s"),
                getCpf(), getNome(),
                getEndereco(), getDataNascimento()));
*/
        /*for(Veiculo veiculo : getVeiculos()) {
            cliente.append(String.format((" | %-7s - %-15s - %-7s"),
                    veiculo.getPlaca(), veiculo.getModelo(), veiculo.getTipo()));
        }*/
        return cliente.toString();
    }


    public String escrever() {
        StringBuilder cliente = new StringBuilder();
        cliente.append("teste");
        /*cliente.append(String.format(("%-14d | %-20s | %-20s | %-5s"),
                getCpf(), getNome(),
                getEndereco(), calcularIdade()));

        for(Veiculo veiculo : getVeiculos()) {
            cliente.append(String.format((" | %-7s - %-15s - %-7s - " +
                            "%-15s - %-4d - %-10s - " +
                            "%-10s"),
                    veiculo.getPlaca(), veiculo.getModelo(), veiculo.getTipo(),
                    veiculo.getMarca(), veiculo.getAno(), veiculo.getCor(),
                    veiculo.getDataInicio()));
        }*/
        return cliente.toString();
    }
}

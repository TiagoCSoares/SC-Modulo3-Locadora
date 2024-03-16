package org.example.entities;

import org.example.resources.escreverArquivos.Exibir;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Veiculo implements Exibir {
    private String placa;
    private final String modelo;
    private final String tipo;
    private final String marca;
    private final int ano;
    private String cor;
    private Pessoa locador;
    private String dataInicio;


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
                   String dataInicio) {
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


    public void setDataInicio(String dataInicio) {
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

    public String getDataInicio() {
        return dataInicio;
    }


    public void alugarVeiculo(Pessoa locador, String dataInicio) {
        this.locador = locador;
        this.dataInicio = dataInicio;
    }

    public void alugarVeiculo(Pessoa locador) {
        this.locador = locador;

        LocalDateTime hora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String horaFormatada = hora.format(formatter);

        this.dataInicio = horaFormatada;
    }

    public void devolverVeiculo() {
        this.locador = null;
        this.dataInicio = null;
    }


    public abstract Double calcularValor(LocalDateTime dataFim);


    public String cabecalho() {
        StringBuilder cabecalho = new StringBuilder();

        cabecalho.append(String.format("%-70s\t | %-7s",
                "Veiculo", "Locador"));

        cabecalho.append(String.format("\n%-7s | %-7s | %-15s | %-12s | %-4s" +
                        " | %-10s\t | %-18s - %-25s",
                "Placa", "Tipo", "Modelo",
                "Marca", "Ano", "Cor",
                "Documento Locador", "Nome Locador"));

        return cabecalho.toString();
    }


    public String exibir() {
        StringBuilder veiculo = new StringBuilder();

        veiculo.append(String.format("\n%-7s | %-7s | %-15s | %-12s | %-4d | %-20s" +
                        " | %-10s\t",
                getPlaca(), getTipo(), getModelo(),
                getMarca(), getAno(), getCor(),
                getDataInicio()));
        if(getLocador() != null) {
            if (getLocador() instanceof PessoaFisica) {
                veiculo.append(String.format(" | %-18s - %-25s",
                        ((PessoaFisica) getLocador()).getStringCpf(), (getLocador()).getNome()));
            } else {
                veiculo.append(String.format(" | %-18s - %-25s",
                        ((PessoaJuridica) getLocador()).getStringCnpj(), (getLocador()).getNome()));
            }
        }
        return veiculo.toString();
    }


    public String escrever() {
        StringBuilder veiculo = new StringBuilder();

        veiculo.append(String.format("\n%-7s | %-7s | %-15s | %-12s | %-4d" +
                        " | %-10s\t",
                getPlaca(), getTipo(), getModelo(),
                getMarca(), getAno(), getCor()));
        if(getLocador() != null) {
            if (getLocador() instanceof PessoaFisica) {
                veiculo.append(String.format(" | %-18s - %-25s",
                        ((PessoaFisica) getLocador()).getCpf(), (getLocador()).getNome()));
            } else {
                veiculo.append(String.format(" | %-18s - %-25s",
                        ((PessoaJuridica) getLocador()).getCnpj(), (getLocador()).getNome()));
            }
        }
        return veiculo.toString();
    }
}

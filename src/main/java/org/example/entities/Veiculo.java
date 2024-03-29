package org.example.entities;

import org.example.resources.escreverArquivos.Exibir;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public  class Veiculo implements Exibir {
    private String placa;
    private final String modelo;
    private final String tipo;
    private final String marca;
    private final int ano;
    private String cor;
    private Pessoa locador;
    private String dataInicio;
    private boolean alugado;


    public Veiculo(String placa, String modelo ,String marca, int ano, String cor, String tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.alugado = false;
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
        this.alugado = false;
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

    public boolean getAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
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
        this.alugado = true;
    }

    public void devolverVeiculo() {
        this.locador = null;
        this.dataInicio = null;
        this.alugado = false;
    }


    public Double calcularValor(String dataFim) {
        LocalDateTime inicio = LocalDateTime.parse(this.getDataInicio(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        LocalDateTime fim = LocalDateTime.parse(dataFim, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        long horasAluguel = ChronoUnit.HOURS.between(inicio, fim);
        long diasAluguel = ChronoUnit.DAYS.between(inicio.toLocalDate(), fim.toLocalDate());

        // Verificar se há horas quebradas para contabilizar como diária completa
        if (horasAluguel % 24 != 0) {
            diasAluguel++; // Incrementar o número de dias se houver horas quebradas
        }

        double valorDiaria;

        // Definir valor da diária com base no tipo de veículo
        if (getTipo().equals("Pequeno")) {
            valorDiaria = 100.0;
        } else if (getTipo().equals("Médio")) {
            valorDiaria = 150.0;
        } else if (getTipo().equals("SUV")) {
            valorDiaria = 200.0;
        } else {
            valorDiaria = 0.0; // Valor padrão caso o tipo de veículo não seja reconhecido
        }

        double valorTotal = valorDiaria * diasAluguel; // Valor total sem desconto

        // Aplicar desconto para pessoa física com mais de 5 dias de aluguel
        if (locador instanceof PessoaFisica && diasAluguel > 5) {
            valorTotal *= 0.95; // Aplicar desconto de 5%
        }
        // Aplicar desconto para pessoa jurídica com mais de 3 dias de aluguel
        else if (locador instanceof PessoaJuridica && diasAluguel > 3) {
            valorTotal *= 0.90; // Aplicar desconto de 10%
        }

        return valorTotal;
    }


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

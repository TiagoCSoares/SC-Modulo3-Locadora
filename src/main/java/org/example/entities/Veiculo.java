package org.example.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Veiculo {
    private String placa;
    private String modelo;
    private final String tipo;
    private final String marca;
    private final int ano;
    private String cor;
    private Pessoa locador;
    private LocalDateTime dataInicio;
    //private String dataFim;


    public Veiculo(String placa, String modelo ,String marca, int ano, String cor, String tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.tipo = tipo;
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

    public void setModelo(String modelo) {
        this.modelo = modelo;
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
}

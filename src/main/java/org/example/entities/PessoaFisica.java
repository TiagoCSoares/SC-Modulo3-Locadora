package org.example.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class PessoaFisica extends Pessoa {

    private final String cpf;
    private String dataNascimento;

    public PessoaFisica(String cpf, String nome, String endereco, String dataNascimento) {
        super(nome, endereco);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }


    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    private int calcularIdade() {
        String dataNascimentoFormatada = dataNascimento.replace("/", "-");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate dataNascimentoLocalDate = LocalDate.parse(dataNascimentoFormatada, formatter);

        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimentoLocalDate, dataAtual);

        return periodo.getYears();
    }
}

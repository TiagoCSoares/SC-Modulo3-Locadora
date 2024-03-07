package org.example.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class PessoaFisica extends Pessoa {

    private String dataNascimento;

    public PessoaFisica(String id, String nome, String endereco, String dataNascimento) {
        super(id, nome, endereco);
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

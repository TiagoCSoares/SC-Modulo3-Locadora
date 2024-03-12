package org.example.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PessoaFisica extends Pessoa {

    private final Long cpf;
    private String dataNascimento;

    public PessoaFisica(Long cpf, String nome, String endereco, String dataNascimento) {
        super(nome, endereco);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }


    public Long getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof PessoaFisica that)) return false;
        return Objects.equals(getCpf(), that.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
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

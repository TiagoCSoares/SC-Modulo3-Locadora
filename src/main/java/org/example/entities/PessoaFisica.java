package org.example.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class PessoaFisica extends Pessoa {

    private final Long cpf;
    private String dataNascimento;

    public PessoaFisica(Long cpf, String nome, String endereco, String dataNascimento, List<Veiculo> veiculos) {
        super(nome, endereco, veiculos);
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


    @Override
    public String cabecalho() {
        return String.format("%-14s | %-20s | %-20s | %-5s | %-7s - %-15s - %-7s",
                "CPF", "Nome",
                "Endereço", "Idade",
                "Placa", "Modelo", "Tipo");
    }

    @Override
    public String exibir() {
        StringBuilder cliente = new StringBuilder();
        cliente.append(String.format(("%-14d | %-20s | %-20s | %-10s"),
                getCpf(), getNome(),
                getEndereco(), getDataNascimento()));

        for(Veiculo veiculo : getVeiculos()) {
            cliente.append(String.format((" | %-7s - %-15s - %-7s"),
                    veiculo.getPlaca(), veiculo.getModelo(), veiculo.getTipo()));
        }
        return cliente.toString();
    }

    @Override
    public String escrever() {
        StringBuilder cliente = new StringBuilder();
        cliente.append(String.format(("%-14d | %-20s | %-20s | %-5s"),
                getCpf(), getNome(),
                getEndereco(), calcularIdade()));

        for(Veiculo veiculo : getVeiculos()) {
            cliente.append(String.format((" | %-7s - %-15s - %-7s - " +
                                    "%-15s - %-4d - %-10s - " +
                                    "%-10s"),
                    veiculo.getPlaca(), veiculo.getModelo(), veiculo.getTipo(),
                    veiculo.getMarca(), veiculo.getAno(), veiculo.getCor(),
                    veiculo.getDataInicio()));
        }
        return cliente.toString();
    }
}

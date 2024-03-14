package org.example.entities;

import java.util.List;

public class PessoaJuridica extends Pessoa{
    private final Long cnpj;

    public PessoaJuridica(Long cnpj, String nome, String endereco, List<Veiculo> veiculos) {
        super(nome, endereco, veiculos);
        this.cnpj = cnpj;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public String exibirPessoaJuridica() {
        return String.format("%14L | %20s | % 20s",
                getCnpj(), getNome(),
                getEndereco());

    }

    @Override
    public String cabecalho() {
        return String.format("%-14s | %-20s | %-20s | %-5s | %-7s - %-15s - %-7s",
                "CNPJ", "Nome",
                "Endereço", "Placa",
                "Modelo", "Tipo");
    }

    @Override
    public String exibir() {
        StringBuilder cliente = new StringBuilder();
        cliente.append(String.format(("%-14L | %-20s | %-20s"),
                getCnpj(), getNome(),
                getEndereco()));
        for(Veiculo veiculo : getVeiculos()) {
            cliente.append(String.format((" | %-7s - %-15s - %-7s"),
                    veiculo.getPlaca(), veiculo.getModelo(), veiculo.getTipo()));
        }

        return cliente.toString();
    }

    @Override
    public String escrever() {
        StringBuilder cliente = new StringBuilder();
        cliente.append(String.format(("%-14L | %-20s | %-20s"),
                getCnpj(), getNome(),
                getEndereco()));

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

package org.example.entities;

import java.util.List;
import java.util.Objects;

public class PessoaJuridica extends Pessoa{
    private final Long cnpj;

    public PessoaJuridica(Long cnpj, String nome, String endereco, List<Veiculo> veiculos) {
        super(nome, endereco, veiculos);
        this.cnpj = cnpj;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public String getStringCnpj() {
        String cnpjString = String.valueOf(cnpj);
        return cnpjString.substring(0, 2) + "." + cnpjString.substring(2, 5) + "." +
                cnpjString.substring(5, 8) + "/" + cnpjString.substring(8, 12) + "-" +
                cnpjString.substring(12);
    }

    public String exibirPessoaJuridica() {
        return String.format("%14L | %20s | % 20s",
                getCnpj(), getNome(),
                getEndereco());

    }

    @Override
    public String cabecalho() {
        StringBuilder cabecalho = new StringBuilder();

        cabecalho.append(String.format("%-64s\t | %-20s",
                "Cliente", "Veiculo alugado"));

        cabecalho.append(String.format("\n%-18s | %-20s | %-20s\t | %-7s - %-15s - %-7s",
                "CPF", "Nome",
                "Endereço",
                "Placa", "Modelo", "Tipo"));

        return cabecalho.toString();
    }

    @Override
    public String exibir() {
        StringBuilder cliente = new StringBuilder();
        cliente.append(String.format(("%-18s | %-20s | %-20s"),
                getStringCnpj(), getNome(),
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof PessoaJuridica that)) return false;
        return Objects.equals(getCnpj(), that.getCnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCnpj());
    }

}

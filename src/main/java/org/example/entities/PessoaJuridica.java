package org.example.entities;

public class PessoaJuridica extends Pessoa{
    private final String cnpj;
    private String dataNascimento;

    public PessoaJuridica(String cnpj, String nome, String endereco, String dataNascimento) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.dataNascimento = dataNascimento;
    }
}

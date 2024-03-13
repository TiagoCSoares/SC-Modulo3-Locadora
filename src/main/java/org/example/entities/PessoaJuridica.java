package org.example.entities;

public class PessoaJuridica extends Pessoa{
    private final Long cnpj;

    public PessoaJuridica(Long cnpj, String nome, String endereco) {
        super(nome, endereco);
        this.cnpj = cnpj;
    }
}

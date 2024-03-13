package org.example.entities;

import java.util.List;

public class PessoaJuridica extends Pessoa{
    private final Long cnpj;

    public PessoaJuridica(Long cnpj, String nome, String endereco, List<Veiculo> veiculos) {
        super(nome, endereco, veiculos);
        this.cnpj = cnpj;
    }
}

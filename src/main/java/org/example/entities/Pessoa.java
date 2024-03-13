package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    private Long id;
    private String nome;
    private String endereco;

    private List<Veiculo> veiculos;

    public Pessoa(String nome, String endereco, List<Veiculo> veiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.veiculos = veiculos != null ? veiculos : new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void associarVeiculo(Veiculo carro) {
        veiculos.add(carro);
    }

    public void desassociarVeiculo(Veiculo carro) {
        veiculos.remove(carro);
    }
}

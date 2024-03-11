package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

    private String nome;
    private String endereco;

    private List<Veiculo> carros = new ArrayList<>();

    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
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

    public void associarVeiculo(Veiculo carro) {
         carros.add(carro);
    }

    public void desassociarVeiculo(Veiculo carro) {
         carros.remove(carro);
    }
}

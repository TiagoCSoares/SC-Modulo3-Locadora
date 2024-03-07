package org.example.entities;

public abstract class Pessoa {

    private final String id;
    private String nome;
    private String endereco;

    //private List<Carro> carros;

    public Pessoa(String id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getId() {
        return id;
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

    // public void associarCarro(Carro carro) {
    //     carros.add(carro);
    // }

    // public void desassociarCarro(Carro carro) {
    //     carros.remove(carro);
    // }
}

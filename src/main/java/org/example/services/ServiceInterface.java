package org.example.services;

import org.example.entities.PessoaFisica;

import java.util.List;

public interface ServiceInterface {


    <T> void criar(T entitie);

    <T> void excluir(T entitie);

    //void escreverArquivo();

    List listar();

    // Método pra encontrar pelo identificador
    <T> T entitieEncontrada(List<T> listaEntities);

    public <T> T pesquisarPorNome(String nome);


    String caminhoDoArquivo();



    <T> T definirIdentificador();

    Boolean verificarIdentificador(String identificadorString);

}

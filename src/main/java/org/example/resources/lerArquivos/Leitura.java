package org.example.resources.lerArquivos;

public interface Leitura {

    <T> T getEntitie(String[] elementos);

    <T> T getAssociados(String elementos);
}

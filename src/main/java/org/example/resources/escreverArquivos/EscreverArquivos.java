package org.example.resources.escreverArquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscreverArquivos {

    public <T extends Exibir> void escreverDados(Exibir exibir, List<T> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(exibir.caminhoDoArquivo()))) {
            for (T objeto : lista) {
                writer.write(objeto.exibir());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
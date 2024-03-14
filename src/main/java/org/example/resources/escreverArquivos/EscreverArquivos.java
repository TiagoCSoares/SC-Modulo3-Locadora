package org.example.resources.escreverArquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscreverArquivos {
    public <T extends Exibir> void escreverDados(String caminho, List<T> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (T objeto : lista) {
                writer.write(objeto.exibir());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
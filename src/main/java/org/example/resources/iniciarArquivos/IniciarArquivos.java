package org.example.resources.iniciarArquivos;

import org.example.services.ServiceInterface;

import java.io.File;
import java.io.IOException;

public class IniciarArquivos {

    public void iniciarArquivos(String caminhoDoArquivo) {
        File novoArquivo = new File(caminhoDoArquivo);
        try {
            if (!novoArquivo.exists()) {
                novoArquivo.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void iniciarPasta() {
        // Caso a pasta arquivos não exista cria a nova Pasta
        novaPasta("src/main/java/org/example/arquivos");
    }


    public static void novaPasta(String pasta) {
        File novaPasta = new File(pasta);
        if (!novaPasta.exists()) {
            novaPasta.mkdirs();
        }
    }
}

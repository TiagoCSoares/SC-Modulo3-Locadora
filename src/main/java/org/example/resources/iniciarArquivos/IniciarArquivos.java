package org.example.resources.iniciarArquivos;

import java.io.File;
import java.io.IOException;

public class IniciarArquivos {


    // TODO: Criar Abstract Service e fazer passagem de generics para iniciarArquivos
    public /*<T extends AbstractService>*/ void iniciarArquivos(/*<T service*/) {
        // Caso a pasta arquivos não exista cria a nova Pasta
        novaPasta("src/main/java/org/example/arquivos");

        // novoArquivo(service.caminhoDoArquivo);

        novoArquivo("src/main/java/org/example/arquivos/pessoasFisicas.txt");
    }


    public static void novaPasta(String pasta) {
        File novaPasta = new File(pasta);
        if (!novaPasta.exists()) {
            novaPasta.mkdirs();
        }
    }

    public static void novoArquivo(String arquivo) {
        File novoArquivo = new File(arquivo);
        try {
            if (!novoArquivo.exists()) {
                novoArquivo.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

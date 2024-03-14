package org.example.resources.lerArquivos;

import org.example.services.ServiceInterface;

import java.io.File;
import java.io.IOException;

public abstract class LerArquivoAbstract implements Leitura{

    protected abstract <T extends ServiceInterface> void preencherBanco(T service);


    public <T extends ServiceInterface> void lerArquivo(T service) {
        File arquivo = new File(service.caminhoDoArquivo());

        try {
            if(!arquivo.exists()) {
                arquivo.createNewFile();
            } else if(arquivo.length() > 0) {
                preencherBanco(service);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

package org.example.resources.lerArquivos;

import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.entities.Veiculo;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;
import org.example.services.ServiceInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

public class LerArquivoPessoJuridica extends LerArquivoAbstract{
    @Override
    public <T> T getEntitie(String[] elementos) {
        String cnpjString = elementos[0].trim();
        Long cnpj = parseLong(cnpjString);

        String nome = elementos[1].trim();
        String endereco = elementos[2].trim();

        List<Veiculo> veiculos = new ArrayList<>();

        for(int i = 3; i < elementos.length; i++) {
            Veiculo veiculo = getAssociados(elementos[i]);
            veiculos.add(veiculo);
        }

        PessoaJuridica pessoaJuridica = new PessoaJuridica(cnpj, nome, endereco, veiculos);
        return (T) pessoaJuridica;
    }

    @Override
    public <T> T getAssociados(String elementos) {
        return null;
    }

    @Override
    protected <T extends ServiceInterface> void preencherBanco(T service) {
        if(service instanceof PessoaJuridicaService pessoaJuridicaService) {
            try (var reader = new BufferedReader(new FileReader(service.caminhoDoArquivo()))) {
                String linha;
                while((linha = reader.readLine()) != null) {
                    String[] elementos = linha.split("\\s*\\|\\s*");
                    if(elementos.length > 0 && !elementos[0].trim().isEmpty()) {
                        PessoaJuridica pessoaJuridica = getEntitie(elementos);
                        pessoaJuridicaService.criar(pessoaJuridica);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

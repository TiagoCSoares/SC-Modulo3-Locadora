package org.example.resources.lerArquivos;

import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.entities.Veiculo;
import org.example.services.PessoaFisicaService;
import org.example.services.ServiceInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

public class LerArquivoPessoFisica extends LerArquivoAbstract{
    @Override
    public <T> T getEntitie(String[] elementos) {
        String cpfString = elementos[0].trim();
        Long cpf = parseLong(cpfString);

        String nome = elementos[1].trim();
        String endereco = elementos[2].trim();
        String dataNascimento = elementos[3].trim();
        List<Veiculo> veiculos = new ArrayList<>();

        for(int i = 4; i < elementos.length; i++) {
            Veiculo veiculo = getAssociados(elementos[i]);
            veiculos.add(veiculo);
        }

        PessoaFisica pessoaFisica = new PessoaFisica(cpf, nome, endereco, dataNascimento, veiculos);
        return (T) pessoaFisica;
    }

    @Override
    public <T> T getAssociados(String elementos) {
        return null;
    }

    @Override
    protected <T extends ServiceInterface> void preencherBanco(T service) {
        if(service instanceof PessoaFisicaService pessoaFisicaService) {
            try (var reader = new BufferedReader(new FileReader(service.caminhoDoArquivo()))) {
                String linha;
                while((linha = reader.readLine()) != null) {
                    String[] elementos = linha.split("\\s*\\|\\s*");
                    if(elementos.length > 0 && !elementos[0].trim().isEmpty()) {
                        PessoaFisica pessoaFisica = getEntitie(elementos);
                        pessoaFisicaService.criar(pessoaFisica);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

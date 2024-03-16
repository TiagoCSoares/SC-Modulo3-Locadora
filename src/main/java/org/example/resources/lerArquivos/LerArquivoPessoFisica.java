package org.example.resources.lerArquivos;

import org.example.entities.*;
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
        String[] veiculoInfo = elementos.split("\\s*-\\s*");
        if (veiculoInfo.length >= 7) { // Verifica se há informações suficientes para criar um objeto Veiculo
            String placa = veiculoInfo[0].trim();
            String modelo = veiculoInfo[1].trim();
            String tipo = veiculoInfo[2].trim();
            String marca = veiculoInfo[3].trim();
            int ano = Integer.parseInt(veiculoInfo[4].trim());
            String cor = veiculoInfo[5].trim();
            String dataInicio = veiculoInfo[6].trim(); // Mantém a string de data de início sem conversão

            if(tipo.equals("Pequeno")){
            VeiculoPequeno veiculo = new VeiculoPequeno(placa, modelo, marca, ano, cor, tipo, null, dataInicio);
            return (T) veiculo;
            } else if(tipo.equals("Medio")){
                VeiculoMedio veiculo = new VeiculoMedio(placa, modelo, marca, ano, cor, tipo, null, dataInicio);
                return (T) veiculo;
            } else {
                VeiculoSUV veiculo = new VeiculoSUV(placa, modelo, marca, ano, cor, tipo, null, dataInicio);
                return (T) veiculo;
            }
        } else {
            // Retorne null ou lance uma exceção, dependendo do que é apropriado para o seu caso
            return null;
        }
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

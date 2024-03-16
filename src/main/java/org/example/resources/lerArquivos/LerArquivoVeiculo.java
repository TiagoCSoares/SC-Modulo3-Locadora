package org.example.resources.lerArquivos;

import org.example.entities.*;
import org.example.services.PessoaJuridicaService;
import org.example.services.ServiceInterface;
import org.example.services.VeiculoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class LerArquivoVeiculo extends  LerArquivoAbstract{
    @Override
    public <T> T getEntitie(String[] elementos) {
        String placa = elementos[0].trim();
        String tipo = elementos[1].trim();
        String modelo = elementos[2].trim();
        String marca = elementos[3].trim();
        String anoStr = elementos[4].trim();
        int ano = parseInt(anoStr);
        String cor = elementos[5].trim();

        Pessoa locador = null;

        for(int i = 7; i < elementos.length; i++) {
            locador = getAssociados(elementos[i]);
        }

        if(tipo.equals("Pequeno")){
            VeiculoPequeno veiculo = new VeiculoPequeno(placa, modelo, marca, ano, cor, tipo, locador, dataInicio);
            return (T) veiculo;
        } else if(tipo.equals("Medio")){
            VeiculoMedio veiculo = new VeiculoMedio(placa, modelo, marca, ano, cor, tipo, locador, dataInicio);
            return (T) veiculo;
        } else {
            VeiculoSUV veiculo = new VeiculoSUV(placa, modelo, marca, ano, cor, tipo, locador, dataInicio);
            return (T) veiculo;
        }
    }

    @Override
    public <T> T getAssociados(String elementos) {
        String[] locadorInfo = elementos.split("\\s*-\\s*");
        if(locadorInfo.length == 4) {
            String cpfStr = locadorInfo[0];
            long cpf = parseLong(cpfStr);
            String nome = locadorInfo[1];
            String endereco = locadorInfo[2];
            String dataNascimento = locadorInfo[3];

            PessoaFisica locadorFisico = new PessoaFisica(cpf, nome, endereco, dataNascimento, null);
            return (T) locadorFisico;
        } else if (locadorInfo.length == 3){
            String cpfStr = locadorInfo[0];
            long cpf = parseLong(cpfStr);
            String nome = locadorInfo[1];
            String endereco = locadorInfo[2];

            PessoaJuridica locadorJuridico = new PessoaJuridica(cpf, nome, endereco,null);
            return (T) locadorJuridico;
        }
        return null;
    }

    @Override
    protected <T extends ServiceInterface> void preencherBanco(T service) {
        if(service instanceof VeiculoService veiculoService) {
            try (var reader = new BufferedReader(new FileReader(service.caminhoDoArquivo()))) {
                String linha;
                while((linha = reader.readLine()) != null) {
                    String[] elementos = linha.split("\\s*\\|\\s*");
                    if(elementos.length > 0 && !elementos[0].trim().isEmpty()) {
                        Veiculo veiculo = getEntitie(elementos);
                        veiculoService.criar(veiculo);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

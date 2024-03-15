package org.example.services;

import org.example.entities.Pessoa;
import org.example.entities.PessoaJuridica;
import org.example.repositories.PessoaJuridicaRepositorio;
import org.example.resources.escreverArquivos.EscreverArquivos;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PessoaJuridicaService implements ServiceInterface{

    private PessoaJuridicaRepositorio pessoaJuridicaRepositorio;

    public PessoaJuridicaService(PessoaJuridicaRepositorio pessoaJuridicaRepositorio) {
        this.pessoaJuridicaRepositorio = pessoaJuridicaRepositorio;
    }

    @Override
    public <T> void criar(T pessoa) {
        PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
        if(pessoa == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if (pessoaJuridica.getNome() == null || pessoaJuridica.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio");
        }
        pessoaJuridicaRepositorio.gravar(pessoa);
    }



    @Override
    public <T> void excluir(T pessoa) {

        PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;

        if(pessoaJuridica == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if(pessoaJuridica.getCnpj() == null) {
            throw new IllegalArgumentException("Cpf do cliente não pode ser nulo");
        }
        Pessoa pessoaSalva = (PessoaJuridica) pessoaJuridicaRepositorio.buscarPorId(pessoaJuridica.getCnpj());
        if(pessoaSalva == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        pessoaJuridicaRepositorio.excluir(pessoaJuridica);
    }


    @Override
    public void escreverArquivo() {
        List<PessoaJuridica> clientes = listar();
        new EscreverArquivos().escreverDados(
                caminhoDoArquivo(), clientes);
    }


    @Override
    public List listar() {
        return pessoaJuridicaRepositorio.listar();
    }

    @Override
    public <T> T entitieEncontrada(List<T> listaEntities) {
        Scanner scanner = new Scanner(System.in);

        PessoaJuridica clienteEncontrado;
        List<PessoaJuridica> listaClientes = (List<PessoaJuridica>) listaEntities;

        if(listaClientes != null && !listaClientes.isEmpty()) {
            for(PessoaJuridica cliente : listaClientes) {
                System.out.printf("%-14s | %-20s\n",
                        "CPF" , "Nome");
                System.out.println(cliente.getCnpj() + " | "
                + cliente.getNome());
                System.out.println("Esse é o clinte desejado?");
                char resposta = scanner.nextLine().charAt(0);
                resposta = Character.toUpperCase(resposta);
                if (resposta == 'S') {
                    clienteEncontrado = cliente;
                    return (T) clienteEncontrado;
                }
            }
        }
        return null;
    }


    public void atualizar(PessoaJuridica cliente, PessoaJuridica novosDados) {
        cliente.setEndereco(novosDados.getEndereco());
        cliente.setNome(novosDados.getNome());
    }

    @Override
    public <T> T pesquisarPorNome(String nome) {
        List<PessoaJuridica> clientes = null;
        PessoaJuridica cliente = null;

        if(nome != null) {
            clientes = pessoaJuridicaRepositorio.buscarPorNome(nome);
            cliente = entitieEncontrada(clientes);
        }

        return (T) cliente;
    }

    @Override
    public String caminhoDoArquivo() {
        return "src/main/java/org/example/arquivos/pessoasJuridicas.txt";
    }


    @Override
    public <T> T definirIdentificador() {
        Scanner scanner = new Scanner(System.in);
        long cpf = 0;

        System.out.println("Digite o CPF (Apenas Digitos):");

        while(scanner.hasNext()){
            if(scanner.hasNextLong()){
                cpf = scanner.nextLong();

                if(!verificarIdentificador(String.valueOf(cpf))){
                    System.out.println("CPF inválido. Digite novamente:");
                    continue;
                }
                break;
            }else{
                System.out.println("Opção inválida, digite apenas os números do cpf.");
                scanner.next();
            }
        }
        return (T) Long.valueOf(cpf);
    }


    @Override
    public Boolean verificarIdentificador(String cnpjString) {
        return (cnpjString.length() == 14);

    }

}

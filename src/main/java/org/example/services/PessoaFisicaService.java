package org.example.services;

import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.repositories.PessoaFisicaRepositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PessoaFisicaService implements ServiceInterface{

    private PessoaFisicaRepositorio pessoaFisicaRepositorio;

    public PessoaFisicaService(PessoaFisicaRepositorio pessoaFisicaRepositorio) {
        this.pessoaFisicaRepositorio = pessoaFisicaRepositorio;
    }

    @Override
    public <T> void criar(T pessoa) {
        PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
        if(pessoa == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if (pessoaFisica.getNome() == null || pessoaFisica.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio");
        }
        pessoaFisicaRepositorio.gravar(pessoa);
    }



    @Override
    public <T> void excluir(T pessoa) {

        PessoaFisica pessoaFisica = (PessoaFisica) pessoa;

        if(pessoaFisica == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if(pessoaFisica.getCpf() == null) {
            throw new IllegalArgumentException("Cpf do cliente não pode ser nulo");
        }
        Pessoa pessoaSalva = (PessoaFisica) pessoaFisicaRepositorio.buscarPorId(pessoaFisica.getCpf());
        if(pessoaSalva == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        pessoaFisicaRepositorio.excluir(pessoaFisica);
    }


    /*@Override
    public void escreverArquivo() {
        List<PessoaFisica> clientes = listar();
        new EscreverArquivos().escreverDados(
                caminhoDoArquivo(), clientes);
    }
*/

    @Override
    public List listar() {
        return pessoaFisicaRepositorio.listar();
    }

    @Override
    public <T> T entitieEncontrada(List<T> listaEntities) {
        Scanner scanner = new Scanner(System.in);

        PessoaFisica clienteEncontrado;
        List<PessoaFisica> listaClientes = (List<PessoaFisica>) listaEntities;

        if(listaClientes != null && !listaClientes.isEmpty()) {
            for(PessoaFisica cliente : listaClientes) {
                System.out.printf("%-14s | %-20s\n",
                        "CPF" , "Nome");
                System.out.println(cliente.getCpf() + " | "
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


    public void atualizar(PessoaFisica cliente, PessoaFisica novosDados) {
        cliente.setEndereco(novosDados.getEndereco());
        cliente.setNome(novosDados.getNome());
    }

    @Override
    public <T> T pesquisarPorNome(String nome) {
        List<PessoaFisica> clientes = null;
        PessoaFisica cliente = null;

        if(nome != null) {
            clientes = pessoaFisicaRepositorio.buscarPorNome(nome);
            cliente = entitieEncontrada(clientes);
        }

        return (T) cliente;
    }

    @Override
    public String caminhoDoArquivo() {
        return "src/main/java/org/example/arquivos/pessoasFisicas.txt";
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


    public String verificarDataNascimento(String dataNascimento) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] elementos = dataNascimento.split("/");
            if (elementos.length == 3) { // Verifica se a entrada contém três partes (dia, mês, ano)
                try {
                    int dia = Integer.parseInt(elementos[0]);
                    int mes = Integer.parseInt(elementos[1]);
                    int ano = Integer.parseInt(elementos[2]);

                    // Validar se a data é válida
                    if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1900) {
                        LocalDate dataNasc = LocalDate.of(ano, mes, dia);
                        LocalDate hoje = LocalDate.now();
                        int idade = hoje.minusYears(dataNasc.getYear()).getYear();

                        // Verificar se a idade é maior ou igual a 18 anos
                        if (idade >= 18) {
                            break; // Sai do loop se a data e a idade forem válidas
                        } else {
                            System.out.println("A pessoa deve ter mais de 18 anos. Por favor, digite novamente:");
                            dataNascimento = scanner.nextLine();
                        }
                    } else {
                        System.out.println("Data de nascimento inválida. Por favor, digite novamente:");
                        dataNascimento = scanner.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Formato inválido. Certifique-se de digitar a data no formato DD/MM/YYYY:");
                    dataNascimento = scanner.nextLine();
                }
            } else {
                System.out.println("Formato inválido. Certifique-se de digitar a data no formato DD/MM/YYYY:");
                dataNascimento = scanner.nextLine();
            }
        }
        return dataNascimento;
    }

    @Override
    public Boolean verificarIdentificador(String cpfString) {
        return (cpfString.length() == 11);

    }

}

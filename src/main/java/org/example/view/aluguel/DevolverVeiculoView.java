package org.example.view.aluguel;

import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;
import org.example.entities.Veiculo;
import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;
import org.example.services.VeiculoService;

import java.util.List;
import java.util.Scanner;

public class DevolverVeiculoView {

    private VeiculoService veiculoService;
    private PessoaJuridicaService pessoaJuridicaService;
    private PessoaFisicaService pessoaFisicaService;

    public DevolverVeiculoView(VeiculoService veiculoService, PessoaJuridicaService pessoaJuridicaService, PessoaFisicaService pessoaFisicaService) {
        this.veiculoService = veiculoService;
        this.pessoaJuridicaService = pessoaJuridicaService;
        this.pessoaFisicaService = pessoaFisicaService;
    }

    public void execute() {
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite a placa do veiculo:");
            String placa = scanner.nextLine();
            // buscar veiculo pela placa
            List<Veiculo> veiculos = veiculoService.listar();
            boolean achou = false;
            Veiculo veiculoAlugado = null;
            for(Veiculo veiculo : veiculos) {
                if(veiculo.getPlaca().equals(placa)) {
                    achou = true;
                    veiculoAlugado = veiculo;
                    break;
                }
            }
            if(!achou) {
                System.out.println("Veiculo não encontrado!");
                return;
            } else if(!veiculoAlugado.getAlugado()) {
                System.out.println("Veiculo não está alugado!");
                return;
            }

            System.out.println("O locador é: " +
                    "\n1 - Pessoa Física" +
                    "\n2 - Pessoa Jurídica");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            while(opcao != 1 && opcao != 2) {
                System.out.println("Opção inválida. Digite novamente:");
                opcao = scanner.nextInt();
            }

            if(opcao == 1) {
                long cpf = pessoaFisicaService.definirIdentificador();
                List<PessoaFisica> pessoas = pessoaFisicaService.listar();
                PessoaFisica achouPessoa = null;
                boolean achouP = false;
                for(PessoaFisica pessoa : pessoas) {
                    if (pessoa.getCpf().equals(cpf)) {
                        achouPessoa = pessoa;
                        achouP = true;
                        break;
                    }
                }
                if(!achouP) {
                    System.out.println("Pessoa não encontrada!");
                    return;
                }



                System.out.println("Digite a data de devolução do aluguel(dd/mm/yyyy:");
                String dataFim = scanner.nextLine();
                System.out.println("Digite a hora de devolução do aluguel(hh:mm):");
                String horaFim = scanner.nextLine();
                dataFim = dataFim + " " + horaFim;
                System.out.println("Valor a ser pago: " + veiculoAlugado.calcularValor(dataFim));

                veiculoAlugado.devolverVeiculo();
                achouPessoa.desassociarVeiculo(veiculoAlugado);


            } else {
                long cnpj = pessoaJuridicaService.definirIdentificador();
                List<PessoaJuridica> pessoas = pessoaJuridicaService.listar();
                PessoaJuridica achouPessoa = null;
                boolean achouP = false;
                for(PessoaJuridica pessoa : pessoas) {
                    if (pessoa.getCnpj().equals(cnpj)) {
                        achouPessoa = pessoa;
                        achouP = true;
                        break;
                    }
                }
                if(!achouP) {
                    System.out.println("Pessoa não encontrada!");
                    return;
                }



                System.out.println("Digite a data de devolução do aluguel(dd/mm/yyyy:");
                String dataFim = scanner.nextLine();
                System.out.println("Digite a hora de devolução do aluguel(hh:mm):");
                String horaFim = scanner.nextLine();
                dataFim = dataFim + " " + horaFim;
                System.out.println("Valor a ser pago: " + veiculoAlugado.calcularValor(dataFim));

                veiculoAlugado.devolverVeiculo();
                achouPessoa.desassociarVeiculo(veiculoAlugado);
            }
        }
    }
}

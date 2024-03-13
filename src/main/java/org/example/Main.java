package org.example;

import org.example.entities.PessoaFisica;
import org.example.entities.VeiculoPequeno;
import org.example.resources.aluguel.Aluguel;
import org.example.view.Menu;

public class Main {
    public static void main(String[] args) {

        Menu menuPrincipal = new Menu();
        //menuPrincipal.execute();

        Long cpf = 2121L;
        PessoaFisica locador = new PessoaFisica(1222L, "João", "Rua 1", "");
        VeiculoPequeno veiculo = new VeiculoPequeno("ABC1234", "Fiat", 2020, "Preto");

        Aluguel aluguel = new Aluguel();
        aluguel.alugarVeiculo(veiculo, locador);


        Double pagar = aluguel.devolverVeiculo(veiculo, locador);
        System.out.println("Valor a pagar: " + pagar);

    }
}
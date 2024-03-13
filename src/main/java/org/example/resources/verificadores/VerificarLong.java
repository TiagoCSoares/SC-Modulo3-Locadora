package org.example.resources.verificadores;

import java.util.Scanner;

public class VerificarLong {

    public long verificarLong(String texto){
        Scanner scanner = new Scanner(System.in);

        System.out.println(texto);
        long option = 0L;
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                option = scanner.nextLong();
                break;
            }else{
                System.out.println("Opção inválida, digite um número inteiro.");
                scanner.next();
            }
        }

        return option;
    }

}

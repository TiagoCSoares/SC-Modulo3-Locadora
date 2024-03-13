package org.example.resources.verificadores;

import java.util.Scanner;

public class VerificarInt {

    public int verificarInt(String texto){
        Scanner scanner = new Scanner(System.in);

        System.out.println(texto);
        int option = 0;
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                option = scanner.nextInt();
                break;
            }else{
                System.out.println("Opção inválida, digite um número inteiro.");
                scanner.next();
            }
        }

        return option;
    }

}

package org.example.view;

import java.util.Scanner;

public abstract class AbstractMenuView {

    private String[] options; // String com os comandos disponíveis

    public AbstractMenuView(String[] options) {
        this.options = options;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEscolha uma opção:");
        for (String option : options) {
            System.out.println(option);
        }

        Integer option = scanner.nextInt();
        if(validOption(option)) {
            executeOption(option);
        } else {
            System.out.println("Opção inválida");
        }
    }



    protected abstract Boolean validOption(Integer option);

    protected abstract void executeOption(Integer option);



}

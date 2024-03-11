package org.example.view.cliente;

import org.example.view.AbstractMenuView;

public class ClienteView extends AbstractMenuView {


    public ClienteView() {
        super(new String[] {
                "1 - Cadastrar Cliente",
                "2 - Listar Clientes",
                "3 - Buscar Cliente por CPF/CNPJ",
                "4 - Atualizar Cliente",
                "5 - Alugar Veículo",
                "6 - Devolver Veículo",
                "0 - Voltar\n"
        });
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 6;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                new CadastrarClienteView().execute();
            case 0:
                System.out.println("Saindo...");
        }
        execute();
    }
}

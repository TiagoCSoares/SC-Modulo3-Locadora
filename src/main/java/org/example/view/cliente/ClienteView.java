package org.example.view.cliente;

import org.example.view.AbstractMenuView;

public class ClienteView extends AbstractMenuView {


    public ClienteView() {
        super(new String[] {
                "1 - Cadastrar Cliente",
                "2 - Listar Clientes",
                "3 - Buscar Cliente por CPF/CNPJ",
                "4 - Atualizar Cliente",
                "0 - Voltar\n"
        });
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 4;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                new CadastrarClienteView().execute();
                break;
            case 2:
                //new ListarClientesView().execute();
                System.out.println("LIstando clientes");
                break;
            case 3:
                //new BuscarClienteView().execute();
                System.out.println("Buscando cliente");
                break;
            case 0:
                break;
        }
        execute();
    }
}

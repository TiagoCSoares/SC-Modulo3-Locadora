package org.example.view.cliente;

import org.example.services.PessoaFisicaService;
import org.example.view.AbstractMenuView;

public class ClienteMenu extends AbstractMenuView {

    private PessoaFisicaService pessoaFisicaService;


    public ClienteMenu(PessoaFisicaService pessoaFisicaService) {
        super(new String[] {
                "1 - Cadastrar Cliente",
                "2 - Listar Clientes",
                "3 - Buscar Cliente por CPF/CNPJ",
                "4 - Atualizar Cliente",
                "0 - Voltar\n"
        });
        this.pessoaFisicaService = pessoaFisicaService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 4;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                new CadastrarClienteView(pessoaFisicaService).execute();
                break;
            case 2:
                new ListarClientesView(pessoaFisicaService).execute();
                break;
            case 3:
                new BuscarClienteView().execute();
                System.out.println("Buscando cliente");
                break;
            case 0:
                return;
        }
        execute();
    }
}

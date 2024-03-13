package org.example.view;

import org.example.services.PessoaFisicaService;
import org.example.view.cliente.ClienteMenu;

public class Menu extends AbstractMenuView{

    private PessoaFisicaService pessoaFisicaService;

    public Menu(PessoaFisicaService pessoaFisicaService) {
        super(new String[]{
                "1 - Usuários",
                "2 - Veículos",
                "3 - Locações",
                "0 - Sair\n"
        });
        this.pessoaFisicaService = pessoaFisicaService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                new ClienteMenu(pessoaFisicaService).execute();
                break;
            /*case 2:
                new VeiculoView().execute();
                break;
            case 3:
                new LocacaoView().execute();
                break;*/
            case 0:
                System.out.println("Saindo...");
                break;
        }
        execute();
    }
}

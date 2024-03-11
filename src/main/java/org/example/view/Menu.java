package org.example.view;

import org.example.view.cliente.ClienteView;

public class Menu extends AbstractMenuView{

    public Menu() {
        super(new String[]{
                "1 - Usuários",
                "2 - Veículos",
                "3 - Locações",
                "0 - Sair\n"
        });
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                new ClienteView().execute();
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
    }
}

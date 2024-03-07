package org.example.view;

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
        return null;
    }

    @Override
    protected void executeOption(Integer option) {

    }
}

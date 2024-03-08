package org.example.view.cliente;

import org.example.view.AbstractMenuView;

public class ClienteView extends AbstractMenuView {


    public ClienteView() {
        super(new String[] {
                "1",
                "2",
                "3",
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

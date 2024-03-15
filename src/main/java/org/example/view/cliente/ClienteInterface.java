package org.example.view.cliente;

import org.example.resources.verificadores.VerificarInt;

public interface ClienteInterface {

    default int tipoPessoa() {
        int option = -1;
        while (option < 0 || option > 2) {
            option = new VerificarInt().verificarInt("""
                    O cliente é:
                    1 - Pessoa Jurídica
                    2 - Pessoa Física
                    0 - Cancelar operação
                    """);
        }
        return option;
    }

}

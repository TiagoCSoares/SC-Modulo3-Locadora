package org.example.view;

import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;
import org.example.services.VeiculoService;
import org.example.view.aluguel.AluguelMenu;
import org.example.view.cliente.ClienteMenu;
import org.example.view.veiculos.VeiculoMenu;

public class Menu extends AbstractMenuView{

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;
    private VeiculoService veiculoService;

    public Menu(PessoaFisicaService pessoaFisicaService,
                PessoaJuridicaService pessoaJuridicaService,
                VeiculoService veiculoService) {
        super(new String[]{
                "1 - Usuários",
                "2 - Veículos",
                "3 - Locações",
                "0 - Sair\n"
        });
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
        this.veiculoService = veiculoService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                new ClienteMenu(pessoaFisicaService,
                        pessoaJuridicaService).execute();
                break;
            case 2:
                new VeiculoMenu(veiculoService).execute();
                break;
            case 3:
                new AluguelMenu(veiculoService,  pessoaFisicaService,
                        pessoaJuridicaService   ).execute();
                break;
            case 0:
                /*pessoaFisicaService.escreverArquivo();
                pessoaJuridicaService.escreverArquivo();
                veiculoService.escreverArquivo();*/
                System.exit(1);
            default:
                System.out.println("Opção não disponível");
        }
        execute();
    }
}

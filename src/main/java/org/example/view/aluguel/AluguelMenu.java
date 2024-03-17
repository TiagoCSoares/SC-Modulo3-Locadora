package org.example.view.aluguel;

import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;
import org.example.services.VeiculoService;
import org.example.view.AbstractMenuView;

public class AluguelMenu extends AbstractMenuView {

    private VeiculoService veiculoService;
    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;
    public AluguelMenu(VeiculoService veiculoService,
                       PessoaFisicaService pessoaFisicaService,
                       PessoaJuridicaService pessoaJuridicaService) {
        super(new String[] {"""
                1 - Alugar Veículo
                2 - Devolver Veículo
                0 - Voltar
                """});
        this.veiculoService = veiculoService;
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 2;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                new AlugarVeiculoView(veiculoService,
                        pessoaJuridicaService,
                        pessoaFisicaService).execute();
                break;
            case 2:
                new DevolverVeiculoView(veiculoService,
                        pessoaJuridicaService,
                        pessoaFisicaService).execute();
                break;
            case 0:
                return;
        }
        execute();
    }
}

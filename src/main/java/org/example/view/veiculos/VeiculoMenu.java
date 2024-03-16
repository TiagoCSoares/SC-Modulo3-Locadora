package org.example.view.veiculos;


import org.example.services.PessoaFisicaService;
import org.example.services.PessoaJuridicaService;
import org.example.services.VeiculoService;
import org.example.view.AbstractMenuView;
import org.example.view.cliente.*;

public class VeiculoMenu extends AbstractMenuView {

    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;
    private VeiculoService veiculoService;


    public VeiculoMenu(PessoaFisicaService pessoaFisicaService,
                       PessoaJuridicaService pessoaJuridicaService,
                       VeiculoService veiculoService) {
        super(new String[] {
                "1 - Cadastrar Veiculo",
                "2 - Listar Veiculos",
                "3 - Buscar Veiculo por Nome",
                "4 - Atualizar Veiculo",
                "5 - Excluir Veiculo",
                "0 - Voltar\n"
        });
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaJuridicaService = pessoaJuridicaService;
        this.veiculoService = veiculoService;
    }

    @Override
    protected Boolean validOption(Integer option) {
            return option >= 0 && option <= 4;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                new CadastrarVeiculoView(veiculoService).execute();
                break;
            case 2:
                new ListarVeiculosView(veiculoService).execute();
                break;
            case 3:
                new BuscarVeiculoView(veiculoService).execute();
                break;
            case 4:
                new AtualizarVeiculoView(veiculoService).execute();
                break;
            case 5:
                new ExcluirVeiculoView(veiculoService).execute();
            case 0:
                return;
        }
    }
}

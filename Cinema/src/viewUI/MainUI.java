package viewUI;

import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.RepositorioSecao;
import repositorio.RepositorioVenda;
import util.Console;
import view.menu.MainMenu;



/**
 *
 * @author lhries
 */
public class MainUI {
    private RepositorioFilmes listaFilmes;
    private RepositorioSalas listaSalas;
    private RepositorioSecao listaSecao;
    private RepositorioVenda listaVenda;

    public MainUI() {
        listaFilmes = new RepositorioFilmes();
        listaSalas = new RepositorioSalas();
        listaSecao = new RepositorioSecao();
        listaVenda = new RepositorioVenda();
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(MainMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case MainMenu.OP_FILMES:
                   new FilmesUI(listaFilmes).executar();
                    break;
                case MainMenu.OP_SALAS:
                   new SalasUI(listaSalas).executar();
                    break;
                case MainMenu.OP_SECOES:
                   new SecoesUI(listaFilmes,listaSalas,listaSecao).executar();
                    break;
                case MainMenu.OP_VENDA:
                  new VendaUI(listaSecao,listaVenda,listaFilmes,listaSalas).executar();
                    break;
                case MainMenu.OP_SAIR:
                    System.out.println("Aplicação finalizada!!!");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != MainMenu.OP_SAIR);
    }
}

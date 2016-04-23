
package viewUI;

import Model.Filmes;
import Model.Salas;
import Model.Secao;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.RepositorioSecao;
import util.Console;
import util.DateUtil;
import view.menu.SecoesMenu;

class SecoesUI {
private RepositorioFilmes Filmes;
private RepositorioSalas Salas;
private RepositorioSecao listaSecao;
    public SecoesUI(RepositorioFilmes listaFilmes, RepositorioSalas listaSalas, RepositorioSecao listaSecao) {
        this.Filmes=listaFilmes;
        this.Salas=listaSalas;
        this.listaSecao=listaSecao;
    }
    public void executar() {
        int opcao = 0;
        do {
            System.out.println(SecoesMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case SecoesMenu.OP_CADASTRAR:
                    cadastrarSecao();
                    break;
                case SecoesMenu.OP_LISTAR:
                    mostrarSecoes();
                    break;
                case SecoesMenu.OP_BUSCAFILME:
                    buscaSecoesPorFilme();
                    break;
                case SecoesMenu.OP_BUSCADATAHORA:
                    buscaSecoesPorDataHora();
                    break;
                case SecoesMenu.OP_BUSCASALA:
                    buscaSecoesPorSala();
                    break;
                case SecoesMenu.OP_FILMESTOP:
                    MostraFilmesEmMaisSecoes();
                    break;
                case SecoesMenu.OP_SALASTOP:
                    MostraSalasEmMaisSecoes();
                    break;
                case SecoesMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != SecoesMenu.OP_VOLTAR);
    } 

    private void cadastrarSecao() {
         System.out.println("========= Cadastro de Secao ============");
        SalasUI sala = new SalasUI(Salas);
        sala.mostrarSalas();
        int numeroSala = Console.scanInt("Informe o numero da sala escolhida:");
        String dataHora = Console.scanString("informe a hora da seção neste formato (hh:mm):");
            Date horario=null;
            boolean AchouSecao=false;
            try {
               horario = DateUtil.stringToHour(dataHora);
               List<Secao> SecaoEncontrada=listaSecao.MostrarSecoesEmUmaSala(numeroSala);
               ArrayList<String> DatasDeSecoes = new ArrayList<String>();
               if(!SecaoEncontrada.isEmpty()){
                   for(Secao S : SecaoEncontrada){
                       String hora = DateUtil.hourToString(S.getDataHora());
                       DatasDeSecoes.add(hora);
                  }
                  
                  for(String HorasSecao : DatasDeSecoes){
                      if(HorasSecao.equals(dataHora)){
                          AchouSecao=true;
                   }
               }
             }
            } catch (ParseException ex) {
                System.out.println("Data ou hora no formato inválido!");
            }
            if(AchouSecao==false && horario!=null){
                Salas Sala = Salas.buscarSalasPorNumero(numeroSala);
                FilmesUI filmescadastrados = new FilmesUI(Filmes);
                filmescadastrados.mostrarFilmes();
                int codigo = Console.scanInt("Informe o codigo do filme para a secao:");
                Filmes FilmeEscolhido = Filmes.buscarFilmePorCod(codigo);
                listaSecao.addSecao(new Secao(Sala,horario,FilmeEscolhido));
                System.out.println("Secao Cadastrada com Sucesso!!!");
            }else{
                System.out.println("Ja existe uma secao na mesma sala e horario informado!!!");
            }
    }

    private void mostrarSecoes() {
                System.out.println("------------- Relatorio de Secoes ----------------\n");
        System.out.println(String.format("%-10s", "NUMERO DA SALA") + "\t"
                + String.format("%-20s", "|HORARIO") + "\t"
                + String.format("%-20s", "|FILME") + "\t"
                + String.format("%-20s", "|GENERO"));
        for (Secao S : listaSecao.getListaSecoes()) {
            String horario = DateUtil.hourToString(S.getDataHora());
            System.out.println(String.format("%-10s", S.getSala().getNumero()) + "\t"
                    + String.format("%-20s", "|" + horario) + "\t"
                    + String.format("%-20s", "|" + S.getFilme().getNome()) + "\t"
                    + String.format("%-20s", "|" + S.getFilme().getGenero()));
        }
    }

    private void buscaSecoesPorFilme() {
        System.out.println("######## Busca de Secoes por Filme ############");
        FilmesUI listaFilmes = new FilmesUI(Filmes);
        listaFilmes.mostrarFilmes();
        int cod_filme=Console.scanInt("Informe o codigo do filme que deseja pesquisar as secoes:");
        List<Secao> SecoesEncontrada=listaSecao.MostrarSecoesDeUmFilme(cod_filme);
        if(!SecoesEncontrada.isEmpty()){
            System.out.println("<< Secoes com este filme >>");
            System.out.println(String.format("%-10s", "NUMERO DA SALA") + "\t"
                + String.format("%-20s", "|HORARIO") + "\t"
                + String.format("%-20s", "|FILME") + "\t"
                + String.format("%-20s", "|GENERO"));
         for (Secao S : SecoesEncontrada) {
            String horario = DateUtil.hourToString(S.getDataHora());
            System.out.println(String.format("%-10s", S.getSala().getNumero()) + "\t"
                    + String.format("%-20s", "|" + horario) + "\t"
                    + String.format("%-20s", "|" + S.getFilme().getNome()) + "\t"
                    + String.format("%-20s", "|" + S.getFilme().getGenero()));
         }
        }else{
            System.out.println("Nenhuma Secao foi encontrada para este filme!!!");
        }
    }

    private void buscaSecoesPorDataHora() {
                System.out.println("######## Busca de Secoes pelo Horario ############");
        String hora_secao=Console.scanString("Informe o horario para busca das secoes, no formato(HH:mm):");
        Date horario=null;
            try {
               horario = DateUtil.stringToHour(hora_secao);
               
            } catch (ParseException ex) {
                System.out.println("Data ou hora no formato inválido!");
            }
        List<Secao> SecoesEncontrada=listaSecao.MostrarSecoesEmUmaHora(horario);
        if(!SecoesEncontrada.isEmpty()){
            System.out.println("<< Secoes no horario das "+hora_secao+">>");
            System.out.println(String.format("%-10s", "NUMERO DA SALA") + "\t"
                + String.format("%-20s", "|HORARIO") + "\t"
                + String.format("%-20s", "|FILME") + "\t"
                + String.format("%-20s", "|GENERO"));
         for (Secao S : SecoesEncontrada) {
            String horaEncontrada = DateUtil.hourToString(S.getDataHora());
            System.out.println(String.format("%-10s", S.getSala().getNumero()) + "\t"
                    + String.format("%-20s", "|" + horaEncontrada) + "\t"
                    + String.format("%-20s", "|" + S.getFilme().getNome()) + "\t"
                    + String.format("%-20s", "|" + S.getFilme().getGenero()));
         }
        }else{
            System.out.println("Nenhuma Secao foi encontrada neste horario!!!");
        }
    }

    private void buscaSecoesPorSala() {
        System.out.println("######## Busca de Secoes por Sala ############");
        SalasUI listaSalas = new SalasUI(Salas);
        listaSalas.mostrarSalas();
        int num_sala=Console.scanInt("Informe o numero da sala que deseja pesquisar as secoes:");
        List<Secao> SecoesEncontrada=listaSecao.MostrarSecoesEmUmaSala(num_sala);
        if(!SecoesEncontrada.isEmpty()){
            System.out.println("<< Secoes com esta sala >>");
            System.out.println(String.format("%-10s", "NUMERO DA SALA") + "\t"
                + String.format("%-20s", "|HORARIO") + "\t"
                + String.format("%-20s", "|FILME") + "\t"
                + String.format("%-20s", "|GENERO"));
         for (Secao S : SecoesEncontrada) {
            String horario = DateUtil.hourToString(S.getDataHora());
            System.out.println(String.format("%-10s", S.getSala().getNumero()) + "\t"
                    + String.format("%-20s", "|" + horario) + "\t"
                    + String.format("%-20s", "|" + S.getFilme().getNome()) + "\t"
                    + String.format("%-20s", "|" + S.getFilme().getGenero()));
         }
        }else{
            System.out.println("Nenhuma Secao foi encontrada para esta sala!!!");
        }  
    }

    private void MostraFilmesEmMaisSecoes() {
        System.out.println("************ Relatório de filmes - Numero de Secoes ***********");
        listaSecao.FilmesEmMaisSecoes();
    }

    private void MostraSalasEmMaisSecoes() {
        System.out.println("************ Relatório de Salas - Numero de Secoes ***********");
        listaSecao.SalasEmMaisSecoes();
    }
}

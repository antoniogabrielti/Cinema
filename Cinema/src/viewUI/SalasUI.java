package viewUI;

import Model.Salas;
import java.util.List;
import repositorio.RepositorioSalas;
import util.Console;
import view.menu.SalasMenu;


class SalasUI {
private RepositorioSalas listaSalas;
    public SalasUI(RepositorioSalas listaSalas) {
        this.listaSalas=listaSalas;
    }
        public void executar() {
        int opcao = 0;
        do {
            System.out.println(SalasMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case SalasMenu.OP_CADASTRAR:
                    cadastrarSala();
                    break;
                case SalasMenu.OP_LISTAR:
                    mostrarSalas();
                    break;
                case SalasMenu.OP_BUSCANUM:
                    buscaSalaPorNumero();
                    break;
                case SalasMenu.OP_BUSCACAPACIDADE:
                    buscaSalaPorCapacidade();
                    break;
                case SalasMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != SalasMenu.OP_VOLTAR);
    }  

    private void cadastrarSala() {
        System.out.println("===== Cadastro de Salas ======");
        int numero = Console.scanInt("Digite o numero da Sala:");
        if (listaSalas.buscarSalasPorNumero(numero)!=null) {
            System.out.println("Sala com esse numero já existe, já cadastrada!!!");
        } else {
            int capacidade = Console.scanInt("Informe a capacidade desta Sala:");
            listaSalas.addSala(new Salas(numero,capacidade));
            System.out.println("Sala "+numero+" cadastrada com sucesso!!!");
        }
    }

    public void mostrarSalas() {
                System.out.println("----------------- Relatorio das Salas --------------\n");
        System.out.println(String.format("%-10s", "NUMERO") + "\t"
                + String.format("%-20s", "|CAPACIDADE"));
        for (Salas S : listaSalas.getListaSalas()) {
            System.out.println(String.format("%-10s", S.getNumero()) + "\t"
                    + String.format("%-20s", "|" + S.getCapacidade()));
        }
    }

    private void buscaSalaPorNumero() {
                System.out.println("######## Busca de Sala pelo Numero ############");
        int numero = Console.scanInt("Informe o numero da sala a qual deseja buscar:");
        Salas SalaEncontrada=listaSalas.buscarSalasPorNumero(numero);
        if(SalaEncontrada!=null){
            System.out.println(String.format("%-10s", "NUMERO") + "\t"
                + String.format("%-20s", "|CAPACIDADE"));
            System.out.println(String.format("%-10s", SalaEncontrada.getNumero()) + "\t"
                    + String.format("%-20s", "|" + SalaEncontrada.getCapacidade()));
        }else{
            System.out.println("Nenhuma Sala foi encontrada com este numero!!!");
        }
    }

    private void buscaSalaPorCapacidade() {
                System.out.println("######## Busca de Salas por Capacidade ############");
        int capacidade = Console.scanInt("Informe a capacidade a qual necessita que a sala tenha:");
        List<Salas> SalasEncontrada=listaSalas.buscarSalasPorCapacidade(capacidade);
        if(!SalasEncontrada.isEmpty()){
            System.out.println("<< Salas com capacidade igual ou superior a necessaria >>");
            for(Salas S : SalasEncontrada){
                System.out.println(String.format("%-10s", "NUMERO") + "\t"
                + String.format("%-20s", "|CAPACIDADE"));
            System.out.println(String.format("%-10s", S.getNumero()) + "\t"
                    + String.format("%-20s", "|" + S.getCapacidade()));             
            }
        }else{
            System.out.println("Nenhuma Sala atende a capacidade solicitada!!!");
        }
    }
    
        
}

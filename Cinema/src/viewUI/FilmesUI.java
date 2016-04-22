package viewUI;

import Model.Filmes;
import repositorio.RepositorioFilmes;
import util.Console;
import view.menu.FilmesMenu;

class FilmesUI {
    private RepositorioFilmes listaFilmes;
    public FilmesUI(RepositorioFilmes listaFilmes) {
        this.listaFilmes=listaFilmes;
    }
        public void executar() {
        int opcao = 0;
        do {
            System.out.println(FilmesMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case FilmesMenu.OP_CADASTRAR:
                    cadastrarFilmes();
                    break;
                case FilmesMenu.OP_LISTAR:
                    mostrarFilmes();
                    break;
                case FilmesMenu.OP_BUSCANOME:
                    buscaFilmePorNome();
                    break;
                case FilmesMenu.OP_BUSCACOD:
                    buscaFilmePorCod();
                    break;
                case FilmesMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != FilmesMenu.OP_VOLTAR);
    }

    private void cadastrarFilmes() {
        System.out.println("========= Cadastro de Filmes ============");
        int cod = Console.scanInt("Informe o codigo do Filme:");
        if (listaFilmes.buscarFilmePorCod(cod)!=null) {
            System.out.println("Filme com esse codigo já existe, já cadastrado!!!");
        } else {
            String nome = Console.scanString("Digite o nome do Filme:");
            String genero = Console.scanString("Informe o genero do Filme:");
            String sinopse = Console.scanString("Digite uma sinopse para este Filme:");
            listaFilmes.addFilme(new Filmes(cod,nome,genero,sinopse));
            System.out.println("Filme "+nome+" cadastrado com sucesso!!!");
        } 
    }
    
        public void mostrarFilmes() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|GENERO") + "\t"
                + String.format("%-20s", "|SINOPSE"));
        for (Filmes filme : listaFilmes.getListaFilmes()) {
            System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
                    + String.format("%-20s", "|" + filme.getNome()) + "\t"
                    + String.format("%-20s", "|" + filme.getGenero()) + "\t"
                    + String.format("%-20s", "|" + filme.getSinopse()));
        }
    }

    private void buscaFilmePorNome() {
        System.out.println("######## Busca de Filme por Nome ############");
        String nome = Console.scanString("Informe o nome do filme para a busca:");
        Filmes FilmeEncontrado=listaFilmes.buscarFilmePorNome(nome);
        if(FilmeEncontrado!=null){
            System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|GENERO") + "\t"
                + String.format("%-20s", "|SINOPSE"));
            System.out.println(String.format("%-10s", FilmeEncontrado.getCodigo()) + "\t"
                    + String.format("%-20s", "|" + FilmeEncontrado.getNome()) + "\t"
                    + String.format("%-20s", "|" + FilmeEncontrado.getGenero()) + "\t"
                    + String.format("%-20s", "|" + FilmeEncontrado.getSinopse()));
        }else{
            System.out.println("Nenhum Filme foi encontrado com este nome!!!");
        }
    }

    private void buscaFilmePorCod() {
        System.out.println("######## Busca de Filme por Codigo ############");
        int cod = Console.scanInt("Informe o codigo do filme para a busca:");
        Filmes FilmeEncontrado=listaFilmes.buscarFilmePorCod(cod);
        if(FilmeEncontrado!=null){
            System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|GENERO") + "\t"
                + String.format("%-20s", "|SINOPSE"));
            System.out.println(String.format("%-10s", FilmeEncontrado.getCodigo()) + "\t"
                    + String.format("%-20s", "|" + FilmeEncontrado.getNome()) + "\t"
                    + String.format("%-20s", "|" + FilmeEncontrado.getGenero()) + "\t"
                    + String.format("%-20s", "|" + FilmeEncontrado.getSinopse()));
        }else{
            System.out.println("Nenhum Filme foi encontrado com este codigo!!!");
        }
    }
}


package repositorio;

import Model.Filmes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioFilmes {
    private List<Filmes> filmes;

    public RepositorioFilmes() {
        filmes = new ArrayList<Filmes>();
    }

    public boolean addFilme(Filmes F) {
       return filmes.add(F);
    }

    public List<Filmes> getListaFilmes() {
        Collections.sort(filmes);
        return filmes;
    }
   public Filmes buscarFilmePorCod(int codigo) {
        for (Filmes F : filmes) {
            if (F.getCodigo()==codigo) {
                return F;
           }
        }
        return null;
    }
   public Filmes buscarFilmePorNome(String Nome){
       for(Filmes Filme : getListaFilmes()){
           if(Filme.getNome().equalsIgnoreCase(Nome)){
               return Filme;
           }
       }
       return null;
   }
}
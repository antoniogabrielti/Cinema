
package repositorio;

import Model.TopSecoesFilmes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioTopFilmes {
    private List<TopSecoesFilmes> topfilmes;

    public RepositorioTopFilmes() {
        topfilmes = new ArrayList<TopSecoesFilmes>();
    }

    public boolean addTopFilme(TopSecoesFilmes Top) {
       return topfilmes.add(Top);
    }

    public List<TopSecoesFilmes> getListaTopFilme() {
        Collections.sort(topfilmes,Collections.reverseOrder());
        return topfilmes;
    }
}

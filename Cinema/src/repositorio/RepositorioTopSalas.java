
package repositorio;


import Model.TopSecoesSalas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioTopSalas {
     private List<TopSecoesSalas> topsalas;

    public RepositorioTopSalas() {
        topsalas = new ArrayList<TopSecoesSalas>();
    }

    public boolean addTopSala(TopSecoesSalas Top) {
       return topsalas.add(Top);
    }

    public List<TopSecoesSalas> getListaTopSalas() {
        Collections.sort(topsalas,Collections.reverseOrder());
        return topsalas;
    }
}

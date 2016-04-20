
package repositorio;

import Model.Salas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioSalas {
       private List<Salas> salas;

    public RepositorioSalas() {
        salas = new ArrayList<Salas>();
    }

    public boolean addSala(Salas S) {
       return salas.add(S);
    }

    public List<Salas> getListaSalas() {
         return salas;
    }
   public Salas buscarSalasPorNumero(int numero) {
        for (Salas S : salas) {
            if (S.getNumero()==numero) {
                return S;
           }
        }
        return null;
    }
   public ArrayList<Salas> buscarSalasPorCapacidade(int Capacidade){
       ArrayList<Salas> SalasComEssaCapacidade = new ArrayList<Salas>();
       for(Salas S : getListaSalas()){
           if(S.getCapacidade()>=Capacidade){
               SalasComEssaCapacidade.add(S);
           }
       }
       return SalasComEssaCapacidade;
   } 
}

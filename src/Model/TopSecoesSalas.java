
package Model;

public class TopSecoesSalas implements Comparable<TopSecoesSalas> {
    private Salas sala;
    private Integer qtdVezesUtilizada;

    public TopSecoesSalas(Salas S,int qtd) {
        this.qtdVezesUtilizada = new Integer(qtd);
        this.sala=S;
    }

    public Salas getSala() {
        return sala;
    }

    public Integer getQtdVezesUtilizada() {
        return qtdVezesUtilizada;
    }
    
    
    @Override
    public int compareTo(TopSecoesSalas Top) {
        return (this.getQtdVezesUtilizada().compareTo(Top.getQtdVezesUtilizada()));
    }
}

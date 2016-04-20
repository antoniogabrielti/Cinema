
package Model;

public class TopSecoesFilmes implements Comparable<TopSecoesFilmes> {
    private Filmes filme;
    private Integer qtdVezesVisto;

    public TopSecoesFilmes(Filmes F,int qtd) {
        this.qtdVezesVisto = new Integer(qtd);
        this.filme=F;
    }

    public Filmes getFilme() {
        return filme;
    }

    public Integer getQtdVezesVisto() {
        return qtdVezesVisto;
    }
    
    @Override
    public int compareTo(TopSecoesFilmes Top) {
        return (this.getQtdVezesVisto().compareTo(Top.getQtdVezesVisto()));
    }
}

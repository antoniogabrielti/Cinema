package Model;

import java.util.Date;

public class Secao implements Comparable<Secao> {
    private Salas sala;
    private Date dataHora;
    private Filmes filme;
    private int qtdDisponivel;

    public Secao(Salas sala, Date dataHora, Filmes filme) {
        this.sala = sala;
        this.dataHora = dataHora;
        this.filme = filme;
        this.qtdDisponivel=sala.getCapacidade();
    }

    public Salas getSala() {
        return sala;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public Filmes getFilme() {
        return filme;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdComprada) {
        this.qtdDisponivel = qtdDisponivel-qtdComprada;
    }
       

    @Override
    public int compareTo(Secao OutraSecao) {
        return (this.getDataHora().compareTo(OutraSecao.getDataHora()));
    }
     
}

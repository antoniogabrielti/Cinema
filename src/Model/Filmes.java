
package Model;

public class Filmes implements Comparable<Filmes> {
    private int codigo;
    private String nome;
    private String genero;
    private String sinopse;

    public Filmes(int codigo, String nome, String genero, String sinopse) {
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    @Override
    public int compareTo(Filmes OutroFilme) {
        return (this.getNome().compareTo(OutroFilme.getNome()));
    }
    
    
}

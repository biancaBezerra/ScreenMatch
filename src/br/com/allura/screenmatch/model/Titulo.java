package br.com.allura.screenmatch.model;


import br.com.allura.screenmatch.excecao.ErroConversaodeAnoException;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;

    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaAvaliacao;
    private int totalDeAvaliacoes;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        //código para tirar o min do final do runtime
        String duracaoSemEspacos = meuTituloOmdb.runtime().replaceAll("\\s*min", "");
        this.nome = meuTituloOmdb.title();
        if (meuTituloOmdb.year().length() > 4) {
            throw  new ErroConversaodeAnoException("Dado com um formato desconecido");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(duracaoSemEspacos);

    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: "+ nome);
        System.out.println("Ano de lançamento: "+ anoDeLancamento);
        System.out.println("Duração em minutos: "+ duracaoEmMinutos);
    }

    public void avalia(double nota){
        somaAvaliacao += nota;
        totalDeAvaliacoes++;
    }

    public double obtemMedia(){
        return somaAvaliacao/totalDeAvaliacoes;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }
    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }


    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Ano de lançamento: " + anoDeLancamento +
                ", Duração em minutos: " + duracaoEmMinutos ;
    }
}

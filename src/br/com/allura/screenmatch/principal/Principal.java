package br.com.allura.screenmatch.principal;

import br.com.allura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.allura.screenmatch.calculo.FiltroRecomendacao;
import br.com.allura.screenmatch.model.Episodio;
import br.com.allura.screenmatch.model.Filme;
import br.com.allura.screenmatch.model.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme favorito = new Filme("The Matrix", 1999);

        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);
        System.out.println("Duração do filme: " + favorito.getDuracaoEmMinutos());

        favorito.exibeFichaTecnica();
        favorito.avalia(2);
        favorito.avalia(3);
        favorito.avalia(5);

        System.out.println("Média de avaliações do filme: " +favorito.obtemMedia());

        Filme shrek = new Filme("Shrek", 1999);

        shrek.setDuracaoEmMinutos(135);
        shrek.setIncluidoNoPlano(true);
        System.out.println("Duração do filme: " + shrek.getDuracaoEmMinutos());

        shrek.exibeFichaTecnica();
        shrek.avalia(9);
        shrek.avalia(8);
        shrek.avalia(9);

        System.out.println("Média de avaliações do filme: " +shrek.obtemMedia());

        Filme walle = new Filme("Wall-e", 2010);

        walle.setDuracaoEmMinutos(120);
        walle.setIncluidoNoPlano(true);
        walle.avalia(8);
        System.out.println("Duração do filme: " + walle.getDuracaoEmMinutos());

        Serie lost = new Serie("Lost", 2000);

        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar a serie: " + lost.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(shrek);
        calculadora.inclui(favorito);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(shrek);
        filtro.filtra(favorito);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(favorito);
        listaDeFilmes.add(shrek);
        listaDeFilmes.add(walle);
        System.out.println("Tamanho da lista - " + listaDeFilmes.size());
        System.out.println("Primeiro filme - " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString de filme: " + listaDeFilmes.get(1).toString());



    }
}


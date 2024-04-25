package br.com.allura.screenmatch.principal;

import br.com.allura.screenmatch.model.Filme;
import br.com.allura.screenmatch.model.Serie;
import br.com.allura.screenmatch.model.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme theMatrix = new Filme("The Matrix", 1999);
        theMatrix.avalia(8);
        Filme shrek = new Filme("Shrek", 2005);
        shrek.avalia(5);
        Filme walle = new Filme("Wall-e", 2010);
        walle.avalia(10);
        Serie lost = new Serie("Lost", 2000);
        lost.avalia(7);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(theMatrix);
        lista.add(shrek);
        lista.add(walle);
        lista.add(lost);

        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
            if (item instanceof Serie serie) {
                System.out.println("Classificação: " + serie.getClassificacao());
            }

        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Tom Hanks");
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Matheus Natchergalie");
        System.out.println("Antes da ordenação: " + buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação: " + buscaPorArtista);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados por titulo: " + lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenação por ano de lançamento: " + lista);
    }
}

package br.com.allura.screenmatch.calculo;

import br.com.allura.screenmatch.model.Filme;
import br.com.allura.screenmatch.model.Serie;
import br.com.allura.screenmatch.model.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void inclui(Titulo titulo) {
        System.out.println("adicionando duração em minutos " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}

import br.com.allura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.allura.screenmatch.calculo.FiltroRecomendacao;
import br.com.allura.screenmatch.model.Episodio;
import br.com.allura.screenmatch.model.Filme;
import br.com.allura.screenmatch.model.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme favorito = new Filme();

        favorito.setNome("The Matrix");
        favorito.setAnoDeLancamento(1999);
        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);
        System.out.println("Duração do filme: " + favorito.getDuracaoEmMinutos());

        favorito.exibeFichaTecnica();
        favorito.avalia(2);
        favorito.avalia(3);
        favorito.avalia(5);

        System.out.println("Média de avaliações do filme: " +favorito.obtemMedia());

        Filme shrek = new Filme();

        shrek.setNome("Shrek");
        shrek.setAnoDeLancamento(1999);
        shrek.setDuracaoEmMinutos(135);
        shrek.setIncluidoNoPlano(true);
        System.out.println("Duração do filme: " + shrek.getDuracaoEmMinutos());

        shrek.exibeFichaTecnica();
        shrek.avalia(9);
        shrek.avalia(8);
        shrek.avalia(9);

        System.out.println("Média de avaliações do filme: " +shrek.obtemMedia());

        Serie lost = new Serie();

        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
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
    }
}


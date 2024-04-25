package br.com.allura.screenmatch.principal;

import br.com.allura.screenmatch.excecao.ErroConversaodeAnoException;
import br.com.allura.screenmatch.model.Buscador;
import br.com.allura.screenmatch.model.ProcessadorDeTitulo;
import br.com.allura.screenmatch.model.Titulo;
import br.com.allura.screenmatch.model.TituloOmdb;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Buscador buscador = new Buscador();
        ProcessadorDeTitulo processador = new ProcessadorDeTitulo();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para a busca");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                TituloOmdb meuTituloOmdb = buscador.buscarTitulo(busca);
                Titulo meuTitulo = processador.processarTitulo(meuTituloOmdb);

                System.out.println("Título já convertido:");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (ErroConversaodeAnoException e) {
                System.out.println("O formato de ano é maior que YYYY");
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Não foi encontrado o filme com o título " + busca);
            } catch (Exception e) {
                System.out.println("Erro na busca do título: " + e.getMessage());
            }
        }

        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
    }
}
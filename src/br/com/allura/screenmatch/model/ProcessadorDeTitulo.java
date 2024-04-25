package br.com.allura.screenmatch.model;

import br.com.allura.screenmatch.excecao.ErroConversaodeAnoException;


public class ProcessadorDeTitulo {
    public Titulo processarTitulo(TituloOmdb tituloOmdb) throws ErroConversaodeAnoException {
        try {
            return new Titulo(tituloOmdb);
        } catch (NumberFormatException e) {
            throw new ErroConversaodeAnoException("Erro ao converter o ano do filme.");
        }
    }
}
package br.com.allura.screenmatch.excecao;

public class ErroConversaodeAnoException extends RuntimeException {
    private String mensagem;
    public ErroConversaodeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}

package exceptions;

public class SolicitacaoSemProdutoException extends Throwable {
    public SolicitacaoSemProdutoException(String mensagem) {
        super("Solicitação inválida! " + mensagem);
    }
}

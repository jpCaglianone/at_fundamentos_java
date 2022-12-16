package exceptions;

public class TipoAquisicaoException extends Throwable {
    public TipoAquisicaoException(String mensagem) {
        super("Tipo de aquisição inválida! " + mensagem);
    }
}

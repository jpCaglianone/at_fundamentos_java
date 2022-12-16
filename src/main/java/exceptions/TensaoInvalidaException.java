package exceptions;

public class TensaoInvalidaException extends Throwable {
    public TensaoInvalidaException(StringBuilder mensagem) {
        super(String.valueOf(mensagem));
    }
}

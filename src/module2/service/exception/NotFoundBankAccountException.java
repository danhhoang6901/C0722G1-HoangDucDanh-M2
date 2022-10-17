package module2.service.exception;

public class NotFoundBankAccountException extends Exception {
    public NotFoundBankAccountException(String message) {
        super(message);
    }
}

package mate.academy.springbootintro.exeption;

public class DataRetrievalException extends RuntimeException {
    public DataRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }
}

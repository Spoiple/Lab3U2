/**
 * Special exception used when creating Isbn
 */
public class IllegalIsbnException extends RuntimeException {

    /**
     * Create new exception
     */
    public IllegalIsbnException () {
    }

    /**
     * Create new exception with given message
     * @param message information about exception
     */
    public IllegalIsbnException (String message) {
        super(message);
    }
}

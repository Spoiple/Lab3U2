import java.io.Serializable;

/**
 * Represents an immutable Isbn
 */
public class Isbn implements Serializable {

    private String isbnStr;
    private static String isbnPattern = "[0-9]{13}";

    private Isbn(String isbnStr) {
        this.isbnStr = isbnStr;
    }

    /**
     * Creates an Isbn object with given String
     * @param isbnStr string representing the number
     * @return Isbn object
     * @throws IllegalIsbnException if isbnStr does not match pattern "[0-9]{13}"
     */
    public static Isbn createIsbn(String isbnStr) throws IllegalIsbnException {
        isbnStr = isbnStr.replaceAll("-", "");
        if (isbnStr.matches(isbnPattern))
            return new Isbn(isbnStr);
        else throw new IllegalIsbnException("Wrong Isbn format");
    }

    /**
     * Returns the isbn as a String
     * @return isbn as String
     */
    public String getIsbnStr() {
        return isbnStr;
    }

    /**
     * Returns the isbn as a String
     * @return isbn as String
     */
    public String toString() {
        return isbnStr;
    }

    /**
     * Checks if isbn is equal
     * @param obj
     * @return true if isbn is equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        Isbn tmp = (Isbn) obj;
        return this.getIsbnStr().equals(tmp.getIsbnStr());
    }
}

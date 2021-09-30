import java.io.Serializable;

public class Isbn implements Serializable {

    private String isbnStr;
    private static String isbnPattern = "[0-9]{13}";

    private Isbn(String isbnStr) {
        this.isbnStr = isbnStr;
    }

    public static Isbn createIsbn(String isbnStr) throws IllegalIsbnException {
        isbnStr = isbnStr.replaceAll("-", "");
        if (isbnStr.matches(isbnPattern))
            return new Isbn(isbnStr);
        else throw new IllegalIsbnException("Wrong Isbn format");
    }

    public String getIsbnStr() {
        return isbnStr;
    }

    public String toString() {
        return isbnStr;
    }
}

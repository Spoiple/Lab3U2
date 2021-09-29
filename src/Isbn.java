import java.io.Serializable;

public class Isbn implements Serializable {

    private String isbnStr;
    private static String isbnPattern = "[0-9]{13}";

    private Isbn(String Isbn) {
        isbnStr = Isbn;
    }

    public static Isbn createIsbn(String Isbn) throws IllegalIsbnException {
        Isbn = Isbn.replaceAll("-", "");
        if (Isbn.matches(isbnPattern))
            return new Isbn(Isbn);
        else throw new IllegalIsbnException("Wrong format");
    }

    public String getIsbnStr() {
        return isbnStr;
    }

}

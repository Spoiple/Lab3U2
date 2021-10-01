import java.io.*;
import java.util.List;

/**
 * Used to export a list of book object to file. Objects in list must implement serializable
 */
public final class BooksIO {

    private BooksIO() {
    }

    /**
     * Saves given list of books to file with given filename
     * @param filename path to save to
     * @param books list of serializable books
     * @throws IOException
     */
    public static void serializeToFile(String filename, List<Book> books) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
            oos.writeObject(books);
        } finally {
            if (oos != null)
                oos.close();
        }
    }

    /**
     * Load a list of books from a file
     * @param filename path to load data from
     * @return List of book object
     * @throws IOException
     * @throws ClassNotFoundException if the file does not contain list of book objects
     */
    public static List<Book> deserializeFromFile(String filename) throws IOException, ClassNotFoundException {
        List<Book> list = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
            list = (List<Book>) ois.readObject();
            return list;
        } finally {
            if (ois != null)
                ois.close();
        }
    }
}

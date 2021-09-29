import java.io.*;
import java.util.List;

public final class BooksIO{

    private BooksIO() {
    }

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

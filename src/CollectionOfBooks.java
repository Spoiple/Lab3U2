import java.util.ArrayList;
import java.util.List;

public class CollectionOfBooks {

    private ArrayList<Book> theBooks;

    public CollectionOfBooks(){
        theBooks = new ArrayList<>();
    }

    public void addBook(Book book) throws IllegalArgumentException {
        if(book == null) throw new IllegalArgumentException("Ingen bok angiven");
        theBooks.add(book);
    }

    public void addBook(List<Book> book) throws IllegalArgumentException {
        if(book == null) throw new IllegalArgumentException("Ingen bok angiven");
        theBooks.addAll(book);
    }

    public void removeBook(Book book){
        theBooks.remove(book);
    }

    public List<Book> searchForBooks(BookMatcher matcher){
        ArrayList<Book> list = new ArrayList<>();

        for (Book theBook : theBooks) {
            if (matcher.matches(theBook))
                list.add(theBook);
        }
        return list;
    }

    public List<Book> getAllBooks() {
        return (List<Book>) theBooks.clone();
    }

    @Override
    public String toString() {
        return "CollectionOfBooks{" +
                "theBooks=" + theBooks +
                '}';
    }
}







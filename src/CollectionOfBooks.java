import java.util.ArrayList;
import java.util.List;

public class CollectionOfBooks {

    private ArrayList<Book> theBooks;

    public CollectionOfBooks(){
        theBooks = new ArrayList<>();
    }

    public void addBook(Book book) throws IllegalArgumentException {
        boolean exists = false;
        for (Book theBook : theBooks) {
            if (theBook.getIsbn().equals(book.getIsbn()))
                exists = true;
        }
        if(book == null) throw new IllegalArgumentException("Argument is null");
        if (exists) throw new IllegalArgumentException("ISBN-number already exists");
        theBooks.add(book);
    }

    public void addBook(List<Book> book) throws IllegalArgumentException {
        if(book == null) throw new IllegalArgumentException("No book is entered");
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
        StringBuilder info = new StringBuilder(10);
        for (Book theBook : theBooks) {
            info.append(theBook.toString() + '\n');
        }
        return info.toString();
    }
}







import java.util.ArrayList;
import java.util.List;

/**
 * CollectionOfBooks stores Book objects.
 * The class provides methods for adding, removing, searching and printing books.
 */
public class CollectionOfBooks {

    private ArrayList<Book> theBooks;

    /**
     * Constructor for class. Contains one data member (a list of books).
     */
    public CollectionOfBooks(){
        theBooks = new ArrayList<>();
    }
    /**
     * Method to add a book to the collection.
     * @throws IllegalArgumentException if Book is null.
     */
    public void addBook(Book book) throws IllegalArgumentException {
        if(book == null) throw new IllegalArgumentException("Argument is null");
        theBooks.add(book);
    }

    /**
     * Adds a list of books to the collection.
     * @param book (List).
     * @throws IllegalArgumentException if no book is entered.
     */
    public void addBook(List<Book> book) throws IllegalArgumentException {
        if(book == null) throw new IllegalArgumentException("No book is entered");
        theBooks.addAll(book);
    }

    /**
     * removes a Book object from the collection.
     * @param book (Book object).
     */
    public void removeBook(Book book){
        theBooks.remove(book);
    }

    /**
     * Method is used when searching and comparing user's search string with all books in the collection.
     * @param matcher (a BookMatcher object).
     * @returns a list with matching results.
     */
    public List<Book> searchForBooks(BookMatcher matcher){
        ArrayList<Book> list = new ArrayList<>();

        for (Book theBook : theBooks) {
            if (matcher.matches(theBook))
                list.add(theBook);
        }
        return list;
    }

    /**
     * Returns shallow copy of internal list of books
     * @return list of all books, (shallow copy)
     */
    public List<Book> getAllBooks() {
        return (List<Book>) theBooks.clone();
    }

    /**
     * Returns a string representation of the books.
     * Uses toString defined in Book.
     * Each book is separated by a new line.
     * @return a string representing the book collection
     */
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(10);
        for (Book theBook : theBooks) {
            info.append(theBook.toString() + '\n');
        }
        return info.toString();
    }
}







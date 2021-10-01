import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Represents a book with immutable title, isbn and genre and mutable rating release date and multiple authors.
 */
public class Book implements Comparable, Serializable {

    private final String title;
    private final Isbn isbn;
    private final Genre genre;
    private int rating;
    private LocalDate releaseDate;
    private ArrayList<Author> authors;

    /**
     * Creates a new book with argument parameters
     * @param title
     * @param genre Enum Genre
     * @param isbn class Isbn
     * @param author class Author
     * @param rating integer with range 1-5
     * @param releaseDate
     */
    public Book(String title, Genre genre, Isbn isbn, Author author, int rating, LocalDate releaseDate) {
        this(title, genre, isbn, author);
        setRating(rating);
        this.releaseDate = releaseDate;
    }

    /**
     * Creates a new book with argument parameters
     * @param title
     * @param genre Enum Genre
     * @param isbn class Isbn
     * @param author class Author
     * @param rating integer with range 1-5
     */
    public Book(String title, Genre genre, Isbn isbn, Author author, int rating) {
        this(title, genre, isbn, author);
        setRating(rating);
    }
    /**
     * Creates a new book with argument parameters
     * @param title
     * @param genre Enum Genre
     * @param isbn class Isbn
     * @param author class Author
     */
    public Book(String title, Genre genre, Isbn isbn, Author author) {
        this(title, genre, isbn);
        addAuthor(author);
    }
    /**
     * Creates a new book with argument parameters
     * @param title
     * @param genre Enum Genre
     * @param isbn class Isbn
     */
    public Book(String title, Genre genre, Isbn isbn) {
        authors = new ArrayList<>();
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
    }

    /**
     * Set book release date
     * @param date LocalDate variable
     */
    public void setReleaseDate(LocalDate date) {
        releaseDate = date;
    }

    /**
     * Set rating value from 1 to 5 inclusive
     * @param rating
     * @throws IllegalArgumentException if value is out of range
     */
    public void setRating(int rating) throws IllegalArgumentException {
        if (rating >= 1 && rating <=5)
            this.rating = rating;
        else throw new IllegalArgumentException("Rating must be 1 to 5");
    }

    /**
     * Adds author to book
     * @param author does not add if null
     */
    public void addAuthor (Author author){
        if (!authors.contains(author))
            authors.add(author);
    }

    /**
     * Creates shallow copy of internal list
     * @return list of all authors, (shallow copy)
     */
    public List<Author> getAuthors(){
        return (List<Author>)authors.clone();
    }

    /**
     * Get book title
     * @return title of book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get Isbn object from book
     * @return Immutable Isbn
     */
    public Isbn getIsbn() {
        return isbn;
    }

    /**
     * Compare title as first key and rating as second
     * @param o other book
     * @return difference represented as an integer
     */
    @Override
    public int compareTo(Object o) {
        Book tmp = (Book) o;
        if (title.equalsIgnoreCase(tmp.title))
            return tmp.rating - this.rating;
        else return this.title.compareToIgnoreCase(tmp.title);
    }

    /**
     * Uses compareTo to check if book is equal
     * @param obj book to compare
     * @return true if compareTo returns 0, false if not
     */
    @Override
    public boolean equals(Object obj) {
        Book tmp = (Book) obj;
        return this.compareTo(tmp) == 0;
    }

    /**
     * Represents book as a string
     * @return Book information as string
     */
    @Override
    public String toString() {
        return  title +
                ", authors: " + authors +
                ", genre: " + genre +
                ", rating: " + rating +
                ", isbn: " + isbn;
    }
}

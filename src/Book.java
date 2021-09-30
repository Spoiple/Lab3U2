import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable, Serializable {

    private final String title;
    private final Isbn isbn;
    private final Genre genre;
    private int rating;
    private LocalDate releaseDate;
    private ArrayList<Author> authors;

    /**
     *
     * @param title
     * @param genre
     * @param isbn
     * @param author
     * @param rating
     */
    public Book(String title, Genre genre, Isbn isbn, Author author, int rating, LocalDate releaseDate) {
        this(title, genre, isbn, author);
        setRating(rating);
        this.releaseDate = releaseDate;
    }

    public Book(String title, Genre genre, Isbn isbn, Author author, int rating) {
        this(title, genre, isbn, author);
        setRating(rating);
    }

    /**
     *
     * @param title
     * @param genre
     * @param isbn
     * @param author
     */
    public Book(String title, Genre genre, Isbn isbn, Author author) {
        this(title, genre, isbn);
        addAuthor(author);
    }

    /**
     *
     * @param title
     * @param genre
     * @param isbn
     */
    public Book(String title, Genre genre, Isbn isbn) {
        authors = new ArrayList<>();
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
    }

    public void setRating(int rating) throws IllegalArgumentException {
        if (rating >= 1 && rating <=5)
            this.rating = rating;
        else throw new IllegalArgumentException("Rating must be 1 to 5");
    }

    public void addAuthor (Author author){
        if (!authors.contains(author))
            authors.add(author);
    }

    public List<Author> getAuthors(){
        return (List<Author>)authors.clone();
    }

    public String getTitle() {
        return title;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    @Override
    public int compareTo(Object o) {
        Book tmp = (Book) o;
        if (title.equalsIgnoreCase(tmp.title))
            return tmp.rating - this.rating;
        else return this.title.compareToIgnoreCase(tmp.title);
    }

    @Override
    public boolean equals(Object obj) {
        Book tmp = (Book) obj;
        return this.compareTo(tmp) == 0;
    }

    @Override
    public String toString() {
        return  title +
                ", authors: " + authors +
                ", genre: " + genre +
                ", rating: " + rating +
                ", isbn: " + isbn;
    }
}

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class UserInterface {

    private CollectionOfBooks theCollection;
    private Scanner scan;

    /**
     * A text based user interface.
     */
    public UserInterface() {
        theCollection = new CollectionOfBooks();
        scan = new Scanner(System.in);
    }

    /**
     * Start UI
     */
    public void run() {
        String filename;
        System.out.println("Enter file to load books from: ");
        filename = scan.nextLine();
        try {
            theCollection.addBook(BooksIO.deserializeFromFile(filename));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        menu();

        try {
            BooksIO.serializeToFile(filename, theCollection.getAllBooks());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void menu(){

        int answer;
        do {
            System.out.println("1. Add book to collection");
            System.out.println("2. Remove book");
            System.out.println("3. Search for books");
            System.out.println("4. List all books");
            System.out.println("5. Save and exit");

            answer = scan.nextInt();
            scan.nextLine();

            switch (answer) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    StringBuilder info = new StringBuilder(10);
                    for (Book book : searchForBooks())
                            info.append(book.toString()+ '\n');
                    if (info.length() == 0)
                        System.out.println("No books found\n");
                    else System.out.println(info);
                    break;
                case 4:
                    listAllBooks();
                    break;
                case 5:
                    System.out.println("Bye Bye");
                    break;
            }
        }
        while (answer != 5);
    }

    private void addBook() {
        String title;
        Genre genre;
        Isbn isbnNr;
        Book book;
        char choice;
        boolean validData;

        System.out.println("Add book to collection\n");
        title = enterBookName();
        genre = enterGenre();
        isbnNr = enterIsbn();

        book = new Book(title, genre, isbnNr);
        System.out.println("Enter authors y/n?: ");
        choice = scan.nextLine().toLowerCase().charAt(0);
        while (choice == 'y') {
            book.addAuthor(createAuthor());
            System.out.println("Enter additional author y/n?: ");
            choice = scan.nextLine().toLowerCase().charAt(0);
        }
        enterRating(book);
        theCollection.addBook(book);
     }

    private Author createAuthor() {
        String name;
        LocalDate birthdate;
        System.out.println("Enter name of author: ");
        name = scan.nextLine();
        System.out.println("Enter author birthdate");
        birthdate = enterDateData();
        return new Author(name, birthdate);
    }

    private Genre enterGenre() {
        int choice;
        System.out.println("Select genre: ");
        for (Genre value : Genre.values()) {
            System.out.println(value.ordinal() + 1 + " " + value);
        }
        do {
            choice = scan.nextInt();
            scan.nextLine();
        }while (choice < 1 ||  choice > Genre.values().length);
        return (Genre.values()[choice-1]);
    }

    private void enterRating(Book book) {
        boolean validData;
        do {
            System.out.println("Enter rating ");
            try {
                book.setRating(scan.nextInt());
                scan.nextLine();
                validData = true;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                validData = false;
            }
        }while (!validData);
    }

    private void removeBook(){
        int choice;
        List<Book> list;
        System.out.println("Remove book");
        list = searchForBooks();
        for (int i = 0; i < list.size(); i++)
            System.out.println(i+1 + " " + list.get(i));
        do {
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input format");
                choice = 0;
            }
        } while (choice == 0);
        theCollection.removeBook(list.get(choice-1));
    }

    private void getBookByTitle(String title){
        System.out.println(theCollection.searchForBooks(new TitleMatcher(title)).get(0));
    }

    private List<Book> searchForBooks() {
        List<Book> result = new ArrayList<>();
        System.out.println("Search for books");
        String searchString = scan.nextLine();
        result.addAll(theCollection.searchForBooks(new TitleMatcher(searchString)));
        result.addAll(theCollection.searchForBooks(new AuthorMatcher(searchString)));
        result.addAll(theCollection.searchForBooks(new IsbnMatcher(searchString)));
        Collections.sort(result);
        return result;
    }

    private void listAllBooks(){
        System.out.println("List all books" + "\n\n" + theCollection);
    }

    private String enterBookName(){
        System.out.println("Enter name of book: ");
        return scan.nextLine();
    }

    private LocalDate enterDateData(){

        boolean validData;
        int[] date = new int[3];
        System.out.println("Enter date (yyyymmdd)\nYear: ");
        do {
            date[0] = scan.nextInt();
            if (date[0] > LocalDate.now().getYear()) {
                validData = false;
                System.out.println("Enter valid year");
            }
            else validData = true;
        }while (!validData);

        System.out.println("Month: ");
        do {
            date[1] = scan.nextInt();
            if (date[1] > 12 || date[1] < 1) {
                validData = false;
                System.out.println("Enter valid month data");
            }
            else validData = true;
        }while (!validData);

        System.out.println("Day: ");
        do {
            date[2] = scan.nextInt();
            if (date[2] < 1 || date[2] > 31) {
                validData = false;
                System.out.println("Enter valid day data");
            }
            else validData = true;
        }while (!validData);

        scan.nextLine();
        return LocalDate.of(date[0], date[1], date[2]);
    }

    private Isbn enterIsbn() {
        Isbn isbnNr = null;
        boolean validData;
        do {
            System.out.println("Enter isbn number: ");
            try {
                isbnNr = Isbn.createIsbn(scan.nextLine());
                validData = true;
            } catch (IllegalIsbnException e) {
                validData = false;
                System.out.println(e.getMessage());
            }
        }while (!validData);

        return isbnNr;
    }
}

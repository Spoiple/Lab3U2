import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class UserInterface {

    private CollectionOfBooks theCollection;
    private Scanner scan;

    public UserInterface() {
        theCollection = new CollectionOfBooks();
        scan = new Scanner(System.in);
    }

    public void run() {
        try {
            theCollection.addBook(BooksIO.deserializeFromFile("collection.dat"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        menu();
    }

    private void menu(){
        int answer;

        do {
            System.out.println("1. Add book to collection");
            System.out.println("2. Remove books");
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
                    searchForBooks();
                    break;
                case 4:
                    listAllBooks();
                    break;
                default: System.out.println("Not a valid option");
            }
        }
        while (answer != 5);
        try {
            BooksIO.serializeToFile("collection.dat", theCollection.getAllBooks());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addBook(){
        theCollection.addBook(new Book("Test", Genre.CRIME, Isbn.createIsbn("1234567890123")));
        theCollection.addBook(new Book("Test2", Genre.CRIME, Isbn.createIsbn("1111111111111")));
        theCollection.addBook(new Book("GW", Genre.CRIME, Isbn.createIsbn("1234567890123")));
    }

    private void removeBook(){
    }

    private void getBookByTitle(String title){
    }

    private void searchForBooks() {
        BookMatcher matcher;
        List<Book> result = new ArrayList<>();
        String searchString = scan.nextLine();
        result.addAll(theCollection.searchForBooks(new TitleMatcher(searchString)));
        result.addAll(theCollection.searchForBooks(new AuthorMatcher(searchString)));
        result.addAll(theCollection.searchForBooks(new IsbnMatcher(searchString)));
        if (result.size() != 0)
            System.out.println(result);
        else System.out.println("No books found");
    }

    private void listAllBooks(){
        System.out.println(theCollection);
    }
}

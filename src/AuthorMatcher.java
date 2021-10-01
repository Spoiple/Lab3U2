
/**
 *  This class implements the Bookmatcher interface.
 *  Used when searching for books with author name.
 */

public class AuthorMatcher implements BookMatcher{

    private String toMatch;

    /**
     * Constructor for AuthorMatcher with one argument.
     * @param toMatch String is put into created object.
     */
    public AuthorMatcher(String toMatch) {
        this.toMatch = toMatch;
    }

    /**
     * Implementation of the abstract method "matches". Comparing toMatch string with a Book Object's author String.
     * @param bookToMatch existing Book object.
     * @returns true if there is a match. else, method returns false.
     */
    @Override
    public boolean matches(Book bookToMatch) {
        for (Author author : bookToMatch.getAuthors()) {
            if (author.getName().toLowerCase().contains(toMatch.toLowerCase()))
                return true;
        }
        return false;
    }
}

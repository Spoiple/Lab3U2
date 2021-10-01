/**
 * Used to match books with Isbn as criteria
 * Implements BookMatcher
 */
public class IsbnMatcher implements BookMatcher{

    private String toMatch;

    /**
     * Creates IsbnMatcher used to match books on Isbn
     * @param toMatch string representing isbn to match against
     */
    public IsbnMatcher(String toMatch) {
        this.toMatch = toMatch;
    }
    /**
     * Checks if book matches this matchers search string
     * @param bookToMatch book to apply bookMatcher method to
     * @return true if isbn is equal, false if not
     */
    @Override
    public boolean matches(Book bookToMatch) {
        return toMatch.equals(bookToMatch.getIsbn().getIsbnStr());
    }
}

/**
 * Used to match books with title as criteria
 * Implements BookMatcher
 */
public class TitleMatcher implements BookMatcher{

    private String toMatch;
    /**
     * Creates TitleMatcher used to match books on title
     * @param toMatch title to match against
     */
    public TitleMatcher(String toMatch) {
        this.toMatch = toMatch;
    }
    /**
     * Checks if book matches this matchers search string
     * @param bookToMatch book to apply bookMatcher method to
     * @return true if title is equal, false if not. Not case-sensitive.
     */
    @Override
    public boolean matches(Book bookToMatch) {
        return bookToMatch.getTitle().toLowerCase().contains(toMatch.toLowerCase());
    }
}

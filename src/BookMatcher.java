/**
 * Interface used to match books with different searching criteria
 */
public interface BookMatcher {

    /**
     * Checks if books matches
     * @param bookToMatch book to apply bookMatcher method to
     * @return true if book matches, false if not
     */
    boolean matches(Book bookToMatch);
}

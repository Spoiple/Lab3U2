public class IsbnMatcher implements BookMatcher{

    private String toMatch;

    public IsbnMatcher(String toMatch) {
        this.toMatch = toMatch;
    }

    @Override
    public boolean matches(Book bookToMatch) {
        return toMatch.equals(bookToMatch.getIsbn().getIsbnStr());
    }
}

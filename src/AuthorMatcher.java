import java.util.Locale;

public class AuthorMatcher implements BookMatcher{

    private String toMatch;

    public AuthorMatcher(String toMatch) {
        this.toMatch = toMatch;
    }

    @Override
    public boolean matches(Book bookToMatch) {
        for (Author author : bookToMatch.getAuthors()) {
            if (toMatch.equalsIgnoreCase(author.getName()))
                return true;
        }
        return false;
    }
}

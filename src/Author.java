import java.io.Serializable;
import java.time.LocalDate;

public class Author implements Serializable {

    private String name;
    private LocalDate dateOfBirth;

    public Author(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

}

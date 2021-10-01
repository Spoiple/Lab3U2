import java.io.Serializable;
import java.time.LocalDate;


/**
 * The auhtor class is used as a template for a new author object.
 */

public class Author implements Serializable {

    private String name;
    private LocalDate dateOfBirth;

    /**
     * Constructor for author.
     * @param name of author.
     * @param dateOfBirth of author.
     *
     */
    public Author(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *  Get method for name of author.
     * @returns name of author.
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Get method for author's date of birth.
     * @returns date of birth of author.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * toString method for printing an authors name and date of birth.
     * @return name and date of birth.
     */
    @Override
    public String toString() {
        return   "[" + name + ", birthday: " + dateOfBirth + "]";
    }

    /**
     * Equal method to compare two author objects.
     * @param obj which is downcasted to an Author Object.
     * @returns true if name and date of birth are the same. else method resturns false.
     */
    @Override
    public boolean equals(Object obj) {
        Author tmp = (Author) obj;
        return this.name.equals(tmp.name) && this.dateOfBirth.equals(tmp.dateOfBirth);
    }
}

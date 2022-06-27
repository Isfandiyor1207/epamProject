package epam.project.bookshop.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Author extends BaseDomain {

    private String firstname;

    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return Objects.equals(firstname, author.firstname) && Objects.equals(lastname, author.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstname, lastname);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Author.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("firstname='" + firstname + "'")
                .add("lastname='" + lastname + "'")
                .toString();
    }
}

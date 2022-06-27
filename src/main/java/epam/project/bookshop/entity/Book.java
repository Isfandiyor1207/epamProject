package epam.project.bookshop.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Book extends BaseDomain {

    private String name;

    private String isbn;

    private String publisher;

    private int publishingYear;

    private Long genreId;

    private Long authorId;

    private Long attachmentId;

    private Long price;

    private Long numberOfBooks;

    //    Long userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(Long numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return publishingYear == book.publishingYear && Objects.equals(name, book.name) && Objects.equals(isbn, book.isbn) && Objects.equals(publisher, book.publisher) && Objects.equals(genreId, book.genreId) && Objects.equals(authorId, book.authorId) && Objects.equals(attachmentId, book.attachmentId) && Objects.equals(price, book.price) && Objects.equals(numberOfBooks, book.numberOfBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, isbn, publisher, publishingYear, genreId, authorId, attachmentId, price, numberOfBooks);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("isbn='" + isbn + "'")
                .add("publisher='" + publisher + "'")
                .add("publishingYear=" + publishingYear)
                .add("genreId=" + genreId)
                .add("authorId=" + authorId)
                .add("attachmentId=" + attachmentId)
                .add("price=" + price)
                .add("numberOfBooks=" + numberOfBooks)
                .toString();
    }
}

package epam.project.bookshop.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Long id;

    protected boolean deleted;

    protected LocalDate createdTime;

    protected LocalDate updatedTime;

    public BaseDomain() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDate getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDate updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDomain that = (BaseDomain) o;
        return deleted == that.deleted && Objects.equals(id, that.id) && Objects.equals(createdTime, that.createdTime) && Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {

        int result = 1;

        result = 31 * result + (id == null ? 0 : id.hashCode());
        result = 31 * result + (deleted ? 1 : 0);

        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseDomain.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("deleted=" + deleted)
                .add("createdTime=" + createdTime)
                .add("updatedTime=" + updatedTime)
                .toString();
    }
}

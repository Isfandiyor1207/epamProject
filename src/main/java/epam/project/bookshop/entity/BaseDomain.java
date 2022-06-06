package epam.project.bookshop.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;

    boolean deleted;

    LocalDate createdTime = LocalDate.now();

    LocalDate updatedTime;

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
        result = 31 * result + (deleted? 1 : 0);

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

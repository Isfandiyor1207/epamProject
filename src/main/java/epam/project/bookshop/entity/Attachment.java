package epam.project.bookshop.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Attachment extends BaseDomain{

    String absoluteName;

    String hashName;

    String uploadPath;

    String extension;

    Long fileSize;

    String contentType;

}

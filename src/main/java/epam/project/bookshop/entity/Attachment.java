package epam.project.bookshop.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Attachment extends BaseDomain {

    private String absoluteName;

    private String hashName;

    private String uploadPath;

    private String extension;

    private Long fileSize;

    private String contentType;

    public Attachment() {
    }

    public String getAbsoluteName() {
        return absoluteName;
    }

    public void setAbsoluteName(String absoluteName) {
        this.absoluteName = absoluteName;
    }

    public String getHashName() {
        return hashName;
    }

    public void setHashName(String hashName) {
        this.hashName = hashName;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Attachment that = (Attachment) o;
        return Objects.equals(absoluteName, that.absoluteName) && Objects.equals(hashName, that.hashName) && Objects.equals(uploadPath, that.uploadPath) && Objects.equals(extension, that.extension) && Objects.equals(fileSize, that.fileSize) && Objects.equals(contentType, that.contentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), absoluteName, hashName, uploadPath, extension, fileSize, contentType);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Attachment.class.getSimpleName() + "[", "]")
                .add("absoluteName='" + absoluteName + "'")
                .add("hashName='" + hashName + "'")
                .add("uploadPath='" + uploadPath + "'")
                .add("extension='" + extension + "'")
                .add("fileSize=" + fileSize)
                .add("contentType='" + contentType + "'")
                .toString();
    }
}

package com.PhotoApp.crashCourse.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import javax.validation.constraints.NotEmpty;
@Table("PHOTOT")
public class PhotoModel {
    @Id
    private Integer ID;
    @NotEmpty
    private String FILENAME;
    private String CONTENTTYPE;
    @JsonIgnore
    private byte[] DATA;
    public PhotoModel(){

    }
    public PhotoModel(Integer id, String fileName) {
        this.ID = id;
        this.FILENAME = fileName;
    }
    public int getId() {
        return ID;
    }
    public void setId(Integer id) {
        this.ID = id;
    }
    public String getFileName() {
        return FILENAME;
    }
    public void setFileName(String fileName) {
        this.FILENAME = fileName;
    }
    public String getContentType() {
        return CONTENTTYPE;
    }
    public void setContentType(String contentType) {
        this.CONTENTTYPE = contentType;
    }

    public byte[] getData() {
        return DATA;
    }

    public void setData(byte[] data) {
        this.DATA = data;
    }
}

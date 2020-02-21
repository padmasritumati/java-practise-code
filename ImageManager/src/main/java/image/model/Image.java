package image.model;

import javax.persistence.*;
import java.sql.Blob;
@Entity
@Table(name="images")
public class Image {

    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="contenttype")
    private String contenttype;

    @Column(name="length")
    private int length;

    @Column(name="content")
    @Lob
    private Blob content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Blob getContent() {
        return content;
    }

    public void setImage(Blob image) {
        this.content = content;
    }
}

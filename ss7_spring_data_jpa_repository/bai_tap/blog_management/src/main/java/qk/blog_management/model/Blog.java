package qk.blog_management.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String name;
    protected String author;
    protected String briefDescription;
    protected String date;

    @ManyToOne(targetEntity = Category.class)
    private Category category;
    
    public Blog() {
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", briefDescription='" + briefDescription + '\'' +
                ", date='" + date + '\'' +
                ", category=" + category +
                '}';
    }

    public Blog(String name, String author, String briefDescription) {
        this.name = name;
        this.author = author;
        this.briefDescription = briefDescription;
    }

    public Blog(String name, String author, String briefDescription, String date) {
        this.name = name;
        this.author = author;
        this.briefDescription = briefDescription;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

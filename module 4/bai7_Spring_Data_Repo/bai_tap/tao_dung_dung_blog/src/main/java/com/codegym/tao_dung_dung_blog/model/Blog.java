package com.codegym.tao_dung_dung_blog.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String datecreate;

    @ManyToOne
    @JoinColumn(name = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Long id, String title, String content, String datecreate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.datecreate = datecreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setBody(String content) {
        this.content = content;
    }

    public String getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(String datecreate) {
        this.datecreate = datecreate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Author")
    private String author;
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "Number_of_Pages")
    private Integer pages;

    public Books() {

    }
    public Books(String title, String author, String isbn, LocalDate dob, Integer pages) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.dob = dob;
        this.pages = pages;
    }

    public Books(Long id, String title, String author, String isbn, LocalDate dob, Integer pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.dob = dob;
        this.pages = pages;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", dob=" + dob +
                ", pages=" + pages +
                '}';
    }
}

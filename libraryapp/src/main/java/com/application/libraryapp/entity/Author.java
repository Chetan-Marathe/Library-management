package com.application.libraryapp.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;


//@Getter
//@Setter
//@NoArgsConstructor

@Entity
@Table(name="authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length=100 ,nullable = false,unique = true)
    private String name;

    @Column(name="description", length=250 ,nullable = false)
    private String description;

    @ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();
    //Set is an interface in java that is part of java.util package
    //It represent collection of element that cannot contain duplicate items
    //HashSet is class in java that implements the Set interface . It stores element in form of hashtable for fast
    //access insertion and deletion


    public Author(String name , String description) {
        this.name = name;
        this.description=description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Author(Long id, String name, String description, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.books = books;
    }
    public Author(){

    }

}

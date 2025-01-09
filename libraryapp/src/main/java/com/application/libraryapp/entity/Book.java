package com.application.libraryapp.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
//With the help of lombok no need to write getter,setter and constructor boilerplatecode
//
//@Getter
//@Setter
//@NoArgsConstructor


@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="isbn", length=50 ,nullable = false,unique = true)
    public String isbn;

    @Column(name="name", length=50 ,nullable = false)
    public String name;

    @Column(name="description", length=250 ,nullable = false)
    public String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "books_authors",
               joinColumns = {@JoinColumn(name="book_id")},
               inverseJoinColumns = {@JoinColumn(name="author_id")}
    )
    public Set<Author> authors = new HashSet<Author>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "books_categories",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")}
    )
    public Set<Category> categories = new HashSet<Category>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "books_publisher",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="publisher_id")}
    )
    public  Set<Publisher> publishers = new HashSet<Publisher>();



    //We are creating this beacause removing should happen from both the ends
    //We have to make sure bidirectionally we are adding and removing things
    public void removepublisher(Publisher publisher){
        this.publishers.remove(publisher);
        publisher.getBooks().remove(publisher);
    }

    public void addpublisher(Publisher publisher){
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }

    public void removeauthor(Author author){
        this.authors.remove(author);
        author.getBooks().remove(author);
    }

    public void addauthor(Author author){
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public void removecategory(Category categories){
        this.categories.remove(categories);
        categories.getBooks().remove(categories);
    }

    public void addcategory(Category categories){
        this.categories.add(categories);
        categories.getBooks().add(this);
    }

    public Book(String isbn,String name,String description) {
        this.isbn = isbn;
        this.name=name;
        this.description=description;
    }

    public Book(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Book(Long id, String isbn, String name, String description, Set<Author> authors, Set<Category> categories, Set<Publisher> publishers) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.authors = authors;
        this.categories = categories;
        this.publishers = publishers;
    }

}

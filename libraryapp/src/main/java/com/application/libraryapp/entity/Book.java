package com.application.libraryapp.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="isbn", length=50 ,nullable = false,unique = true)
    private String isbn;

    @Column(name="name", length=50 ,nullable = false)
    private String name;

    @Column(name="description", length=250 ,nullable = false)
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "books_authors",
               joinColumns = {@JoinColumn(name="book_id")},
               inverseJoinColumns = {@JoinColumn(name="author_id")}
    )
    private Set<Author> author = new HashSet<Author>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "books_categories",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")}
    )
    private Set<Category> categories = new HashSet<Category>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "books_publisher",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="publisher_id")}
    )
    private Set<Publisher> publisher = new HashSet<Publisher>();



}
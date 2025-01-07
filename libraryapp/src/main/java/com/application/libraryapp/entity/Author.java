package com.application.libraryapp.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length=100 ,nullable = false,unique = true)
    private String name;

    @Column(name="description", length=250 ,nullable = false)
    private String description;

    @ManyToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Book> Books = new HashSet<Book>();
}

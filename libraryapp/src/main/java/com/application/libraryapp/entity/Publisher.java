package com.application.libraryapp.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",length = 50,nullable = false,unique = true)
    private String name;

    @ManyToMany(mappedBy = "publisher",cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();
}

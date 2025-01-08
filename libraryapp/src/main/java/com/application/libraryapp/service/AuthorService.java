package com.application.libraryapp.service;

import com.application.libraryapp.entity.Author;
import com.application.libraryapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthor(){
        return authorRepository.findAll();
    }

    public Author findAuthorByID(Long id){
        Author author;
        return author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public void Createauthor(Author author){
        authorRepository.save(author);
    }

    public void Updateauthor(Author author){
        authorRepository.save(author);
    }

    public void Deleteauthor(Long id){
        Author author;
        author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.deleteById(author.getId());
    }
}

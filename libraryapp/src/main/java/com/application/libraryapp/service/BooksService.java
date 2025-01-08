package com.application.libraryapp.service;

import com.application.libraryapp.entity.Book;
import com.application.libraryapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BookRepository bookRepository;


    /*Functonalities needed are
     * fetch all records
     * fetch specific record
     * add
     * Delete a specific record
     * update
     *
     *
     *
     * /books :- getting all the books from the database
     * /book/{id} :- getting a specific book from the database
     * /save-book :- add a new book to the database
     * /remove-book/{id} :-  remove a specific book from the database
     * /save-update/{id} :- saves the update to a specific book
     * */

    public List<Book> findAllbooks(){
        return bookRepository.findAll();
    }

    public Book Findabook(Long id){
        Book book;
        book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
        return book;
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }


}

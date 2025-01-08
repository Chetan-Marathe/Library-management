package com.application.libraryapp.controller;

import com.application.libraryapp.entity.Book;
import com.application.libraryapp.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class BookController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public String findAllBooks( Model model){
        List<Book> books = booksService.findAllbooks();
        model.addAttribute("books",books);
        return "books";
    }
}

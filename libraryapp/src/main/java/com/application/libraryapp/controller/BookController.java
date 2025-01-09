package com.application.libraryapp.controller;

import com.application.libraryapp.entity.Book;
import com.application.libraryapp.service.AuthorService;
import com.application.libraryapp.service.BooksService;
import com.application.libraryapp.service.CategoryService;
import com.application.libraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class BookController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public String findAllBooks( Model model){
        List<Book> books = booksService.findAllbooks();
        model.addAttribute("books",books);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String findBook(@PathVariable Long id, Model model) {
        Book book = booksService.Findabook(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("remove-book/{id}")
    public String deleteBook(@PathVariable Long id,Model model){
        booksService.deletebook(id);
        model.addAttribute("books",booksService.findAllbooks());
        return "books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = booksService.Findabook(id);
        if (book == null) {
            model.addAttribute("errorMessage", "Book not found!");
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.FindAll());
        model.addAttribute("publishers", publisherService.FindallPublisher());
        model.addAttribute("authors", authorService.findAllAuthor());
        return "update-book";
    }

    @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.FindAll());
            model.addAttribute("publishers", publisherService.FindallPublisher());
            model.addAttribute("authors", authorService.findAllAuthor());
            return "update-book";
        }

        Book existingBook = booksService.Findabook(id);
        if (existingBook == null) {
            model.addAttribute("errorMessage", "Book not found!");
            return "update-book";
        }

        existingBook.setIsbn(book.getIsbn());
        existingBook.setName(book.getName());
        existingBook.setDescription(book.getDescription());
        existingBook.setCategories(book.getCategories());
        existingBook.setAuthors(book.getAuthors());
        existingBook.setPublishers(book.getPublishers());

        booksService.updateBook(existingBook);
        return "redirect:/books";
    }

    @GetMapping("/add-book")
    public String addBook( Book book, Model model) {
        model.addAttribute("categories", categoryService.FindAll());
        model.addAttribute("publishers", publisherService.FindallPublisher());
        model.addAttribute("authors", authorService.findAllAuthor());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book, BindingResult result,Model model){
        if(result.hasErrors()){
            return "add-book";
        }
        booksService.createBook(book);
        model.addAttribute("books",booksService.findAllbooks());
        return "redirect:/books";

    }






}

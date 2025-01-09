package com.application.libraryapp.controller;

import com.application.libraryapp.entity.Author;
import com.application.libraryapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController{

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String listAauthors(Model model){
        model.addAttribute("authors",authorService.findAllAuthor());
        return "authors";
    }

    @GetMapping("/remove-author/{id}")
    public String deleteAuthor(@PathVariable Long id,Model model){
        authorService.Deleteauthor(id);
        model.addAttribute("authors",authorService.findAllAuthor());
        return "authors";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id,Model model){
        model.addAttribute("author",authorService.findAuthorByID(id));
        return "update-author";
    }

    @PostMapping("/update-author/{id}")
    public String saveUpdate(@PathVariable Long id,Author author, BindingResult result,Model model){
        if(result.hasErrors()){
            return "update-author";
        }
        authorService.Updateauthor(author);
        model.addAttribute("authors",authorService.findAllAuthor());
        return "redirect:/authors";
    }

    @GetMapping("/add-author")
    public String showCreateAuthor(Author author){
        return "add-author";
    }

    @PostMapping("/save-author")
    public String SaveAuthor(Author author,BindingResult result,Model model){
        if(result.hasErrors()){
            return "add-author";
        }
        authorService.Createauthor(author);
        model.addAttribute("authors",authorService.findAllAuthor());
        return "redirect:/authors";
    }
}

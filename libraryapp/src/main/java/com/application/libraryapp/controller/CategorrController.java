package com.application.libraryapp.controller;

import com.application.libraryapp.entity.Category;
import com.application.libraryapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategorrController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findALLCategories(Model model){
        model.addAttribute("categories",categoryService.FindAll());
        return "categories";
    }

    @GetMapping("/remove-category/{id}")
    public String deleteCategory(@PathVariable Long id,Model model){
        categoryService.Deletecategory(id);
        model.addAttribute("categories",categoryService.FindAll());
        return "categories";
    }

    @GetMapping("update-category/{id}")
        public String UpdateCategory(@PathVariable Long id,Model model){
         model.addAttribute("category",categoryService.FindbyId(id));
         return "update-category";
    }

    @PostMapping("/update-category/{id}")
    public String saveCategory(@PathVariable Long id, Category category, BindingResult result,Model model){
        if(result.hasErrors()){
            return "update-category";
        }
        categoryService.UpdateCategory(category);
        model.addAttribute("categories",categoryService.FindAll());
        return "redirect:/categories";
    }

    @GetMapping("/add-category")
    public String ShowcreateCategory(Category category){
        return "add-category";
    }

    @PostMapping("/save-category")
    public String savecategory(Category category, BindingResult result ,Model model ){
        if(result.hasErrors()){
            return "add-category";
        }
        categoryService.CreateCategory(category);
        model.addAttribute("categories",categoryService.FindAll());
        return "redirect:/categories";
    }

}

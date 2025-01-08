package com.application.libraryapp.service;

import com.application.libraryapp.entity.Category;
import com.application.libraryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> FindAll(){
        return categoryRepository.findAll();
    }

    public Category FindbyId(Long id){
        Category category;
        return category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
    }

    public void CreateCategory(Category category){
        categoryRepository.save(category);
    }

    public void UpdateCategory(Category category){
        categoryRepository.save(category);
    }

    public void Deletecategory(Long id){
        Category category;
        category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        categoryRepository.deleteById(category.getId());
    }
}

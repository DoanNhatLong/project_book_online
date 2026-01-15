package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Category;
import com.example.c09_project_book.repository.CategoryRepository;
import com.example.c09_project_book.repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService{
    private ICategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}

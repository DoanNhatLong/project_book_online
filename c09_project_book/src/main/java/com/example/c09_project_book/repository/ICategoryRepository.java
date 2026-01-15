package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}

package com.codegym.back_end_sprint_2.service.impl;


import com.codegym.back_end_sprint_2.model.entities.Category;
import com.codegym.back_end_sprint_2.repositories.CategoryRepository;
import com.codegym.back_end_sprint_2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long idDelete) {
        categoryRepository.deleteById(idDelete);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }
}

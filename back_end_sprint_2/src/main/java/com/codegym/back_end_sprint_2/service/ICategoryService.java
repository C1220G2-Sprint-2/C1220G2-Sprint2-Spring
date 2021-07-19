package com.codegym.back_end_sprint_2.service;



import com.codegym.back_end_sprint_2.model.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();


    Optional<Category> findById(Long id);

    Category save(Category project);

    void deleteById(Long idDelete);
}

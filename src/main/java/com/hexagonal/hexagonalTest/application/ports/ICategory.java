package com.hexagonal.hexagonalTest.application.ports;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.presentation.models.CreateCategory;
import com.hexagonal.hexagonalTest.presentation.models.UpdateCategory;

import java.util.List;

public interface ICategory {
    Category save(Category category);

    List<Category> findAll();

    Category findById(Long id);

    void deleteById(Long id);

    Category update( CreateCategory createCategory,Long id);
    Category patch(Long id, UpdateCategory category);
}

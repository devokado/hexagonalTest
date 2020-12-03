package com.hexagonal.hexagonalTest.domain.catalouge;

import com.hexagonal.hexagonalTest.adapter.web.CreateCategory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findById(Long id);

    void deleteById(Long id);

    Category update(Category category, CreateCategory createCategory);
    Category patch(Long id, Category toBePatchedCat) throws InvocationTargetException, IllegalAccessException;
}

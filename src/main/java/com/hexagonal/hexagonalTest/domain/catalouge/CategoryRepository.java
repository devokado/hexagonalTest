package com.hexagonal.hexagonalTest.domain.catalouge;

import com.hexagonal.hexagonalTest.adapter.web.CreateCategory;
import com.hexagonal.hexagonalTest.adapter.web.ResponseCategory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CategoryRepository {
    ResponseCategory save(Category category);

    List<Category> findAll();

    Category findById(Long id);

    void deleteById(Long id);

    Category update( CreateCategory createCategory,Long id);
    Category patch(Long id, Category toBePatchedCat) throws InvocationTargetException, IllegalAccessException;
}

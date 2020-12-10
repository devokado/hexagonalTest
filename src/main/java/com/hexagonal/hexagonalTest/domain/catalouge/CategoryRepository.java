package com.hexagonal.hexagonalTest.domain.catalouge;

import com.hexagonal.hexagonalTest.adapter.web.CreateCategory;
import com.hexagonal.hexagonalTest.adapter.web.ResponseCategory;
import com.hexagonal.hexagonalTest.adapter.web.UpdateCategory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CategoryRepository {
    Category save(Category category);

    List<Category> findAll();

    Category findById(Long id);

    void deleteById(Long id);

    Category update( CreateCategory createCategory,Long id);
    Category patch(Long id, UpdateCategory category);
}

package com.hexagonal.hexagonalTest.domain.catalouge;

import java.util.List;

public interface CategoryRepository {
    Category save(Category category);
    List<Category> findAll();
}

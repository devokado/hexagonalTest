package com.hexagonal.hexagonalTest.domain.catalouge;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);
    List<Category> findAll();
   Optional<Category>  findById(Long id);
}

package com.hexagonal.hexagonalTest.adapter.jpa;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.CategoryRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CategoryJpaRepositoryAdapter implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;

    public CategoryJpaRepositoryAdapter(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }


    @Override
    public Category save(Category category) {
        return null;
    }
}

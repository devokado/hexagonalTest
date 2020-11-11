package com.hexagonal.hexagonalTest.adapter.persistence;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.app.Port.outgoing.loadCategoryPort;
import com.hexagonal.hexagonalTest.app.Port.outgoing.saveCategoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Component
public class CategoryRepository implements loadCategoryPort, saveCategoryPort {
    @Autowired
    private SpringDataCategoryRepository repository;
    @Override
    public List<Category> load(Integer id) {

        return repository.findAllById(Collections.singleton(id));
    }

    @Override
    public Category save(Category category) {
    repository.save(category);
    return category;

    }
}

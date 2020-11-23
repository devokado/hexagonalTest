package com.hexagonal.hexagonalTest.adapter.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class categoryController {
  @Autowired
  private CategoryRepository categoryRepository;


    @PostMapping(value = "/create")
    public Category createCategory(@Valid @RequestBody CreateCategory createCategory){
        Category category = createCategory.asCategory();
        categoryRepository.save(category);
        return category;
    }
}

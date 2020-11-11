package com.hexagonal.hexagonalTest.adapter.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.app.Port.incoming.categoryUsecase;
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
  private categoryUsecase categoryUsecase;

    @PostMapping(value = "/create")
    public Category createCategory(@RequestBody @Valid Category category){
        categoryUsecase.category(category);
        return category;
    }
}

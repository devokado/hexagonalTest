package com.hexagonal.hexagonalTest.adapter.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
  @Autowired
  private CategoryRepository categoryRepository;


    @PostMapping(value = "/create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CreateCategory createCategory){
        Category category = createCategory.asCategory();
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(category));
    }

    @GetMapping()
    public ResponseEntity<?> getAllCategories(Model model){
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories",categories);
        return ResponseEntity.status(HttpStatus.FOUND).body(categories);

    }


}

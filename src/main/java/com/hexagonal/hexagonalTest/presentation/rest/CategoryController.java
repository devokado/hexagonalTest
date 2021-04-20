package com.hexagonal.hexagonalTest.presentation.rest;


import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.application.ports.ICategory;
import com.hexagonal.hexagonalTest.presentation.models.CreateCategory;
import com.hexagonal.hexagonalTest.presentation.models.ResponseCategory;
import com.hexagonal.hexagonalTest.presentation.models.UpdateCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    private ICategory ICategory;



    @PostMapping(value = "create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CreateCategory createCategory) {
        Category category = createCategory.asCategory();
        Category responseCategory = ICategory.save(category);
        ResponseCategory response = ResponseCategory.from(responseCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<?> getAllCategories(Model model) {
        List<Category> categories = ICategory.findAll();
        List<ResponseCategory> responseCategories = categories
                .stream()
                .map(category -> ResponseCategory.from(category))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(responseCategories);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable("categoryId") Long id) {
        Category category = ICategory.findById(id);
        ResponseCategory responseCategory = ResponseCategory.from(category);
        return ResponseEntity.status(HttpStatus.OK).body(responseCategory);
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<?> updateCategoryDetails(@PathVariable("categoryId") Long id,
                                                   @Valid @RequestBody CreateCategory createCategory) {
        ResponseCategory responseCategory = ResponseCategory.from(ICategory.update(createCategory,id));
        return ResponseEntity.status(HttpStatus.OK).body(responseCategory);


    }

    @PatchMapping("{categoryId}")
    public ResponseEntity<?>  PatchById(@PathVariable("categoryId") Long id,@RequestBody UpdateCategory category){
        ResponseCategory response = ResponseCategory.from(ICategory.patch(id,category));
       return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("categoryId") Long id) {
        ICategory.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }


}

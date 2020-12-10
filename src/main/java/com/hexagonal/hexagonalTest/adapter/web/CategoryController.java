package com.hexagonal.hexagonalTest.adapter.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;



    @PostMapping(value = "create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CreateCategory createCategory) {
        Category category = createCategory.asCategory();
        Category responseCategory = categoryRepository.save(category);
        ResponseCategory response = ResponseCategory.from(responseCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<?> getAllCategories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return ResponseEntity.status(HttpStatus.OK).body(model);

    }

    @GetMapping("{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable("categoryId") Long id) {
        Category category = categoryRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<?> updateCategoryDetails(@PathVariable("categoryId") Long id,
                                                   @Valid @RequestBody CreateCategory createCategory) {


        return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.update(createCategory,id));


    }
    //todo: some errors
    @PatchMapping("{categoryId}")
    public ResponseEntity<?>  PatchById(@PathVariable("categoryId") Long id,@RequestBody UpdateCategory category){
        ResponseCategory response =ResponseCategory.from(categoryRepository.patch(id,category));
       return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("categoryId") Long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }


}

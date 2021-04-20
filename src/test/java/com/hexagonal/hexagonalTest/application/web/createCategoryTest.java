package com.hexagonal.hexagonalTest.application.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.Name;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import com.hexagonal.hexagonalTest.presentation.models.CreateCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class createCategoryTest {
    @Autowired
    private static Validator validator;


    @Test
    public void convertsToCategoryDomain() throws Exception{

        CreateCategory createCategory = new CreateCategory("phone","phone",4,"sss", "2",1,true);
        Category expectedCategory = new Category(new NameEN("phone"),new Name("phone"),4,"sss","2",1,true);
        assertThat(createCategory.asCategory())
                .isEqualToIgnoringGivenFields(expectedCategory, "id","udt","cdt");
    }
    @Test
    public void createCategoryWithNullEntry(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        CreateCategory createCategory = new CreateCategory("شلوار",null,1,"image","22",2,true);
       // Category category = new Category(new NameEN(null),new Name(null),2,"sss","22",3,true);
        Category asCategory = createCategory.asCategory();
        validator.validate(asCategory).stream().forEach(violation -> System.out.println(violation.getMessage()));
        Set<ConstraintViolation<Category>> violations = validator.validate(asCategory);

        assertThat(violations.size()).isEqualTo(2);

    }
    @Test
    public void categoryWithNullReturnError(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        Category category =new Category(new NameEN(null),new Name(null),2,"sss","22",3,true);
        validator.validate(category).stream().forEach(violation -> System.out.println(violation.getMessage()));
        Set<ConstraintViolation<Category>> violations = validator.validate(category);
        assertThat(violations.size()).isEqualTo(2);
    }



}

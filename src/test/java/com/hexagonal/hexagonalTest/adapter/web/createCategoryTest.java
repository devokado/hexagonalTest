package com.hexagonal.hexagonalTest.adapter.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class createCategoryTest {
    @Autowired
    private static Validator validator;


//    @Test
//    public void convertsToCategoryDomain() throws Exception{
//        Date date = new Date();
//        long time = date.getTime();
//        Timestamp ts = new Timestamp(time);
//        CreateCategory createCategory = new CreateCategory("phone","phone",4,"sss", (char) 2,1,true);
//        Category expectedCategory = new Category("phone","phone",4,"sss",(char)2,1,true,false,ts,ts);
//        assertThat(createCategory.asCategory())
//                .isEqualToIgnoringGivenFields(expectedCategory, "id");
//    }

    @Test
    public void whenNullName_ThenOneConstraintViolation(){

        validator = Validation.buildDefaultValidatorFactory().getValidator();
        NameEN nameEN = new NameEN(null);
        validator.validate(nameEN).stream().forEach(violation -> System.out.println(violation.getMessage()));
        Set<ConstraintViolation<NameEN>> violations = validator.validate(nameEN);

        assertThat(violations.size()).isEqualTo(1);

    }
    @Test
    public void whenNameIsSmallerThan4Character(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        NameEN nameEN = new NameEN("by");
        validator.validate(nameEN).stream().forEach(violation -> System.out.println(violation.getMessage()));
        Set<ConstraintViolation<NameEN>> violations = validator.validate(nameEN);

        assertThat(violations.size()).isEqualTo(1);

    }
}

package com.hexagonal.hexagonalTest.Domain;

import com.hexagonal.hexagonalTest.domain.catalouge.Name;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationsTest {
    @Autowired
    private static Validator validator;

    @Test
    public void whenNullNameEn_ThenOneConstraintViolation(){

        validator = Validation.buildDefaultValidatorFactory().getValidator();
        NameEN nameEN = new NameEN(null);
        validator.validate(nameEN).stream().forEach(violation -> System.out.println(violation.getMessage()));
        Set<ConstraintViolation<NameEN>> violations = validator.validate(nameEN);

        assertThat(violations.size()).isEqualTo(1);

    }
    @Test
    public void whenNameEnIsSmallerThan4Character(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        NameEN nameEN = new NameEN("by");
        validator.validate(nameEN).stream().forEach(violation -> System.out.println(violation.getMessage()));
        Set<ConstraintViolation<NameEN>> violations = validator.validate(nameEN);

        assertThat(violations.size()).isEqualTo(1);

    }
    @Test
    public void whenNameEnIsNotEnglish(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        NameEN nameEN = new NameEN("شلوار");
        validator.validate(nameEN).stream().forEach(violation -> System.out.println(violation.getMessage()));
        Set<ConstraintViolation<NameEN>> violations = validator.validate(nameEN);
        assertThat(violations.size()).isEqualTo(1);

    }
    @Test
    public void whenNullName_ThenOneConstraintViolation(){

        validator = Validation.buildDefaultValidatorFactory().getValidator();
        Name name = new Name(null);
        validator.validate(name).stream().forEach(violation -> System.out.println(violation.getMessage()));
        Set<ConstraintViolation<Name>> violations = validator.validate(name);

        assertThat(violations.size()).isEqualTo(1);

    }
    @Test
    public void whenNameIsSmallerThan4Character(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        Name name = new Name("by");
        validator.validate(name).stream().forEach(violation -> System.out.println(violation.getMessage()));
        Set<ConstraintViolation<Name>> violations = validator.validate(name);

        assertThat(violations.size()).isEqualTo(1);

    }
}

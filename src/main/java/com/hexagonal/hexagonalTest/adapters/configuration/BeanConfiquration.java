package com.hexagonal.hexagonalTest.adapters.configuration;

import com.hexagonal.hexagonalTest.HexagonalTestApplication;
import com.hexagonal.hexagonalTest.adapters.persistence.CategoryRepository;
import com.hexagonal.hexagonalTest.application.Services.categoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HexagonalTestApplication.class)
public class BeanConfiquration {
    @Bean
    categoryService categoryService(CategoryRepository repository){
        return new categoryService(repository,repository);
    }
}

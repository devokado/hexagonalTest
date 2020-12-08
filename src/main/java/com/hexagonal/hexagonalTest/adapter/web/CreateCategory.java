package com.hexagonal.hexagonalTest.adapter.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.Name;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategory {
    @Valid
    private String name_en;
    @Valid
    private String name;
    private int parent;
    private String image;
    private String kind;
    private int priority;
    private boolean visibility;

    @Valid
    public Category asCategory(){
        return new Category(new NameEN(name_en),new Name(name),parent,image,kind,priority,visibility);
    }

}

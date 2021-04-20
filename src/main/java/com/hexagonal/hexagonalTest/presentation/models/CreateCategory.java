package com.hexagonal.hexagonalTest.presentation.models;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.Name;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategory {
    //TODO: validations need improvements!!
    @Valid
    @NotNull(message = "Name can not be null!")
    @Size(min=4, message = "Name length should be more than 3 characters!")
    @Pattern(regexp = "[a-zA-Z]+")
    private String name_en;
    @Valid
    @NotNull(message = "Name can not be null!")
    @Size(min=4, message = "Name length should be more than 3 characters!")
    private String name;
    private Integer parent;
    private String image;
    private String kind;
    private Integer priority;
    private boolean visibility;

    public Category asCategory(){
        return new Category(new NameEN(name_en),new Name(name),parent,image,kind,priority,visibility);
    }

}

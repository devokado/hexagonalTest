package com.hexagonal.hexagonalTest.domain.catalouge;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
public class Name {

    @NotNull(message = "Name can not be null!")
    @Size(min=4, message = "Name length should be more than 3 characters!")
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public String asRaw(){
        return name;
    }
}

package com.hexagonal.hexagonalTest.domain.catalouge;

import lombok.NonNull;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ToString
public class NameEN {

    @NotNull(message = "Name can not be null!")
    @Size(min=4, message = "Name length should be more than 3 characters!")
    @Pattern(regexp = "\"[\\p{Alnum}\\p{Punct}\\s]\"", message = "Just English characters are accepted!")
    private final String nameEn;

    public NameEN(String nameEn) {

            this.nameEn = nameEn;

    }


    public String getNameEn() {
        return nameEn;
    }

    public String asRaw(){
        return nameEn;
    }

    //todo: check if English? / Spring validation / Parent value object


}

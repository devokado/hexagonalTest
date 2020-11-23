package com.hexagonal.hexagonalTest.domain.catalouge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NameEN {

    @NotNull(message = "Name can not be null!")
    @Size(min = 4, message = "Name length should be more than 3 characters!")
    @Pattern(regexp = "\"[\\p{Alnum}\\p{Punct}\\s]\"", message = "Just English characters are accepted!")
    private String nameEn;


    public String getNameEn() {
        return nameEn;
    }

    public String asRaw() {
        return nameEn;
    }

    //todo: check if English? / Spring validation / Parent value object


}

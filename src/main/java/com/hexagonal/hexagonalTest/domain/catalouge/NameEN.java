package com.hexagonal.hexagonalTest.domain.catalouge;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString

public class NameEN {

    @NotNull(message = "Name can not be null!")
    @Size(min=4, message = "Name length should be more than 3 characters!")

    private  String nameEn;

   // @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
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

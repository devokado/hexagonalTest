package com.hexagonal.hexagonalTest.domain.catalouge;

import lombok.ToString;

@ToString
public class NameEN {
    private final String nameEn;

    public NameEN(String nameEn) {
        if(!isValidName(nameEn)){
            throw new IllegalArgumentException("Name should be more than 3 charachters");
        }
        this.nameEn = nameEn;
    }
    private boolean isValidName(String nameEn){
      return nameEn.length() > 3;
    }

}

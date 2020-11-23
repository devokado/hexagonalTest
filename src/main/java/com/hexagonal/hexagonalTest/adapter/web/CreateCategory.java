package com.hexagonal.hexagonalTest.adapter.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategory {
    @Valid
    private NameEN name_en;
    private String name;
    private int parent;
    private String image;
    private Character kind;
    private int priority;
    private boolean visibility;


    Category asCategory(){
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        return new Category(name_en,name,parent,image,kind,priority,visibility,false,ts,ts);
    }

}

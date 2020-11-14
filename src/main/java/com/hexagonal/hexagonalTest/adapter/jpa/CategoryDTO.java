package com.hexagonal.hexagonalTest.adapter.jpa;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category")
 class CategoryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name_en;
    private  String name;
    private int parent;
    private String image;
    private Character kind;
    private int priority;
    private boolean visibility;
    private boolean deleted;
    private Timestamp cdt;
    private Timestamp udt;




    public static CategoryDTO from(Category category){
        return new CategoryDTO(category.getId(),category.getName_en(),category.getName(),category.getParent(),category.getImage(),category.getKind(),category.getPriority(),category.isVisibility(),category.isDeleted(),category.getCdt(),category.getUdt());
    }
    Category asCategory(){
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        return new Category(name_en,name,parent,image,kind,priority,visibility,false,ts,ts);
    }

}

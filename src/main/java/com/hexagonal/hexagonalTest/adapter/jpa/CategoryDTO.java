package com.hexagonal.hexagonalTest.adapter.jpa;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    @CreationTimestamp
    private Timestamp cdt;
    @UpdateTimestamp
    private Timestamp udt;



//todo: No data && modelMapper ??
    public static CategoryDTO from(Category category){
        return new CategoryDTO(category.getId(),category.getName_en().asRaw(),category.getName(),category.getParent(),category.getImage(),category.getKind(),category.getPriority(),category.isVisibility(),category.isDeleted(),category.getCdt(),category.getUdt());
    }

    Category asCategory(){
        return new Category(new NameEN(name_en),name,parent,image,kind,priority,visibility);
    }


}

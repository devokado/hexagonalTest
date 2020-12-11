package com.hexagonal.hexagonalTest.adapter.jpa;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.Name;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "category")
class CategoryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Valid
    private String name_en;
    @Valid
    private String name;
    private Integer parent;
    private String image;
    private String kind;
    private Integer priority;
    private Boolean visibility;
    private Boolean deleted;
    @CreationTimestamp
    private Timestamp cdt;
    @UpdateTimestamp
    private Timestamp udt;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name_en, String name, int parent, String image, String kind, int priority, boolean visibility, boolean deleted, Timestamp cdt, Timestamp udt) {
        this.id = id;
        this.name_en = name_en;
        this.name = name;
        this.parent = parent;
        this.image = image;
        this.kind = kind;
        this.priority = priority;
        this.visibility = visibility;
        this.deleted = deleted;
        this.cdt = cdt;
        this.udt = udt;
    }

    public static CategoryDTO from(Category category) {
        return new CategoryDTO(category.getId(), category.getName_en().asRaw(), category.getName().asRaw(), category.getParent(), category.getImage(), category.getKind(), category.getPriority(), category.isVisibility(), category.isDeleted(), category.getCdt(), category.getUdt());
    }


    Category asCategory() {
        return new Category(new NameEN(name_en), new Name(name), parent, image, kind, priority, visibility);
    }

    Category asResponse() {
        return new Category(id, new NameEN(name_en), new Name(name), parent, image, kind, priority, visibility);
    }



}

package com.hexagonal.hexagonalTest.application.Domain.catalouge;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
@Entity

public class Category {
    @Id
    private Integer id;
    private String name_en;
    private  String name;
    private Integer parent;
    private String image;
    private Character kind;
    private Integer priority;
    private boolean visibility;
    private boolean deleted;
    private Timestamp cdt;
    private Timestamp udt;

    public Category() {
    }

    public Category(Integer id, String name_en, String name, Integer parent, String image, Character kind, Integer priority, boolean visibility, boolean deleted, Timestamp cdt, Timestamp udt) {
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

    public Integer getId() {
        return id;
    }

    public String getName_en() {
        return name_en;
    }

    public String getName() {
        return name;
    }

    public Integer getParent() {
        return parent;
    }

    public String getImage() {
        return image;
    }

    public Character getKind() {
        return kind;
    }

    public Integer getPriority() {
        return priority;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Timestamp getCdt() {
        return cdt;
    }

    public Timestamp getUdt() {
        return udt;
    }
}

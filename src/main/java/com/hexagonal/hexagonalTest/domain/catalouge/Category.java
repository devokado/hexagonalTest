package com.hexagonal.hexagonalTest.domain.catalouge;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@ToString
public class Category {

    @Getter
    @Setter
    private Long id;

    private  NameEN name_en;
    private  String name;
    private  int parent;
    private  String image;
    private  Character kind;
    private  int priority;
    private  boolean visibility;
    private  boolean deleted;
    private  Timestamp cdt;
    private  Timestamp udt;

    public Category() {
    }

    //todo: solid setter? No data
    public Category(NameEN name_en, String name, int parent, String image, Character kind, int priority, boolean visibility) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        this.name_en = name_en;
        this.name = name;
        this.parent = parent;
        this.image = image;
        this.kind = kind;
        this.priority = priority;
        this.visibility = visibility;
        this.deleted = false;
        this.cdt = ts;
        this.udt = ts;
    }
    public Category(Long id,NameEN name_en, String name, int parent, String image, Character kind, int priority, boolean visibility) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        this.id = id;
        this.name_en = name_en;
        this.name = name;
        this.parent = parent;
        this.image = image;
        this.kind = kind;
        this.priority = priority;
        this.visibility = visibility;
        this.deleted = false;
        this.cdt = ts;
        this.udt = ts;
    }


    public NameEN getName_en() {
        return name_en;
    }

    public String getName() {
        return name;
    }

    public int getParent() {
        return parent;
    }

    public String getImage() {
        return image;
    }

    public Character getKind() {
        return kind;
    }

    public int getPriority() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category that = (Category) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

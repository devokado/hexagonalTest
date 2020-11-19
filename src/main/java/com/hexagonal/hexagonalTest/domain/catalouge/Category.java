package com.hexagonal.hexagonalTest.domain.catalouge;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@ToString
@AllArgsConstructor
public class Category {

    @Getter
    @Setter
    private Long id;

    private final String name_en;
    private final String name;
    private final int parent;
    private final String image;
    private final Character kind;
    private final int priority;
    private final boolean visibility;
    private final boolean deleted;
    private final Timestamp cdt;
    private final Timestamp udt;

    //todo: solid setter? No data
    public Category(String name_en, String name, int parent, String image, Character kind, int priority, boolean visibility, boolean deleted, Timestamp cdt, Timestamp udt) {
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



    public String getName_en() {
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

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

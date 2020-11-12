package com.hexagonal.hexagonalTest.domain.catalouge;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

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

    public Category(String name_en, String name, int parent, String image, Character kind, int priority, boolean visibility, boolean deleted, Timestamp cdt, Timestamp udt) {
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
}

package com.hexagonal.hexagonalTest.adapter.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;

public class ResponseCategory {
    private Long id;
    private String name_en;
    private String name;
    private int parent;
    private String image;
    private String kind;
    private int priority;
    private boolean visibility;
    private String cdt;
    private String udt;


    public ResponseCategory(Long id, String name_en, String name, int parent, String image, String kind, int priority, boolean visibility, String cdt, String udt) {
        this.id = id;
        this.name_en = name_en;
        this.name = name;
        this.parent = parent;
        this.image = image;
        this.kind = kind;
        this.priority = priority;
        this.visibility = visibility;
        this.cdt = cdt;
        this.udt = udt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getCdt() {
        return cdt;
    }

    public void setCdt(String cdt) {
        this.cdt = cdt;
    }

    public String getUdt() {
        return udt;
    }

    public void setUdt(String udt) {
        this.udt = udt;
    }

    public static ResponseCategory from(Category category){
        return new ResponseCategory(category.getId(),category.getName_en().asRaw(),category.getName().asRaw(),category.getParent(),category.getImage(),category.getKind(),category.getPriority(),category.isVisibility(),category.getCdt().toString(),category.getUdt().toString());
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    @Override
    public String toString() {
        return "ResponseCategory{" +
                "id ="+id +
                ",NameEn =" + name_en +
                ", name =" + name +
                ", parent =" + parent +
                ", image =" + image +
                ", kind =" + kind +
                ", priority =" + priority +
                ", visibility =" + visibility +
                ", cdt =" + cdt +
                ", udt =" + udt +
                '}';
    }
}

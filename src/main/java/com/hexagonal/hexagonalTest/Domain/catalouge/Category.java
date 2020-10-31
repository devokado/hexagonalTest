package com.hexagonal.hexagonalTest.Domain.catalouge;

import java.sql.Timestamp;

public class Category {
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
}

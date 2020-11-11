package com.hexagonal.hexagonalTest.app.Port.outgoing;


import com.hexagonal.hexagonalTest.domain.catalouge.Category;

import java.util.List;

public interface loadCategoryPort {
    List<Category> load(Integer id);
}

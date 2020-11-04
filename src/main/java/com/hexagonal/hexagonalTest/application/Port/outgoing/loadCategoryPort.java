package com.hexagonal.hexagonalTest.application.Port.outgoing;


import com.hexagonal.hexagonalTest.application.Domain.catalouge.Category;

import java.util.List;

public interface loadCategoryPort {
    List<Category> load(Integer id);
}

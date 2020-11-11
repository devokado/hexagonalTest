package com.hexagonal.hexagonalTest.app.Port.outgoing;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;

public interface saveCategoryPort {
    Category save(Category category);

}

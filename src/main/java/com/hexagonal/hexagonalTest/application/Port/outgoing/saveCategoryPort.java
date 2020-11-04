package com.hexagonal.hexagonalTest.application.Port.outgoing;

import com.hexagonal.hexagonalTest.application.Domain.catalouge.Category;

public interface saveCategoryPort {
    void save(Category category);

}

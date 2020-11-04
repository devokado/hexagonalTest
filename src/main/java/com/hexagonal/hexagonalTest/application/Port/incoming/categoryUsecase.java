package com.hexagonal.hexagonalTest.application.Port.incoming;

import com.hexagonal.hexagonalTest.application.Domain.catalouge.Category;

import java.sql.Timestamp;

public interface categoryUsecase {
    void category(Category category);
}

package com.hexagonal.hexagonalTest.application.Services;

import com.hexagonal.hexagonalTest.application.Domain.catalouge.Category;
import com.hexagonal.hexagonalTest.application.Port.incoming.categoryUsecase;
import com.hexagonal.hexagonalTest.application.Port.outgoing.loadCategoryPort;
import com.hexagonal.hexagonalTest.application.Port.outgoing.saveCategoryPort;

import java.sql.Timestamp;

public class categoryService implements categoryUsecase {
    private loadCategoryPort loadCategoryPort;
    private saveCategoryPort saveCategoryPort;

    public categoryService(loadCategoryPort loadCategoryPort, saveCategoryPort saveCategoryPort) {
        this.loadCategoryPort = loadCategoryPort;
        this.saveCategoryPort = saveCategoryPort;
    }


    @Override
    public void category(Category category) {
        saveCategoryPort.save(category);

    }
}

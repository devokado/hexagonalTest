package com.hexagonal.hexagonalTest.app.Services;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.app.Port.incoming.categoryUsecase;
import com.hexagonal.hexagonalTest.app.Port.outgoing.loadCategoryPort;
import com.hexagonal.hexagonalTest.app.Port.outgoing.saveCategoryPort;

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

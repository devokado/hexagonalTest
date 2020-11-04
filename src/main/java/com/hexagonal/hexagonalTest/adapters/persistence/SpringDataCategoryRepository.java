package com.hexagonal.hexagonalTest.adapters.persistence;

import com.hexagonal.hexagonalTest.application.Domain.catalouge.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataCategoryRepository extends JpaRepository<Category,Integer> {

}

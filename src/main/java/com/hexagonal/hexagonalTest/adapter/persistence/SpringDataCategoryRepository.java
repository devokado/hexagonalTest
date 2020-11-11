package com.hexagonal.hexagonalTest.adapter.persistence;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataCategoryRepository extends JpaRepository<Category,Integer> {

}

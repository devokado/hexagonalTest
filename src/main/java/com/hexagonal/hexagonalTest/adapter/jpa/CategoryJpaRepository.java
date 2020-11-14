package com.hexagonal.hexagonalTest.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryDTO, Long> {

}

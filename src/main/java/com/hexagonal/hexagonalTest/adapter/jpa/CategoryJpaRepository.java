package com.hexagonal.hexagonalTest.adapter.jpa;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryDTO, Long> {
    @Override
    Optional<CategoryDTO> findById(Long aLong);

}

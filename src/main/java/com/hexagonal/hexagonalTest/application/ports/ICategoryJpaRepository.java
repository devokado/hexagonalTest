package com.hexagonal.hexagonalTest.application.ports;


import com.hexagonal.hexagonalTest.Infrastructure.persistance.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ICategoryJpaRepository extends JpaRepository<CategoryDTO, Long> {
    @Override
    Optional<CategoryDTO> findById(Long aLong);

}

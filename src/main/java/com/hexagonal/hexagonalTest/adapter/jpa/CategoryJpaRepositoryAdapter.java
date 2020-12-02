package com.hexagonal.hexagonalTest.adapter.jpa;

import com.hexagonal.hexagonalTest.adapter.web.CreateCategory;
import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.CategoryRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class CategoryJpaRepositoryAdapter implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;

    public CategoryJpaRepositoryAdapter(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }


    @Override
    public Category save(Category category) {
        CategoryDTO dto= CategoryDTO.from(category);
        dto= categoryJpaRepository.save(dto);
        return dto.asCategory();
    }

    @Override
    public List<Category> findAll() {
        return categoryJpaRepository.findAll()
                .stream()
                .map(CategoryDTO::asCategory)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findById(Long id) {
        Optional<CategoryDTO> dto =categoryJpaRepository.findById(id);
        return dto.map(CategoryDTO::asCategory);
    }

    @Override
    public void deleteById(Long id) {
      categoryJpaRepository.deleteById(id);
    }

    @Override
    public Category update(Category category, CreateCategory createCategory) {
        CategoryDTO dto = CategoryDTO.from(category);
        dto.setName(createCategory.getName());
        dto.setName_en(createCategory.getName_en());
        dto.setParent(createCategory.getParent());
        dto.setKind(createCategory.getKind());
        dto.setPriority(createCategory.getPriority());
        dto.setImage(createCategory.getImage());
        dto.setVisibility(createCategory.isVisibility());
        return dto.asCategory();
    }


}

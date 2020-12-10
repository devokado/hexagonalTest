package com.hexagonal.hexagonalTest.adapter.jpa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexagonal.hexagonalTest.adapter.web.CreateCategory;
import com.hexagonal.hexagonalTest.adapter.web.UpdateCategory;
import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import javax.validation.Valid;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class CategoryJpaRepositoryAdapter implements CategoryRepository {
    @Autowired
    private NullAwareBeanUtilsBean beanUtils;

    private final CategoryJpaRepository categoryJpaRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public CategoryJpaRepositoryAdapter(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }


    @Override
    public Category save(@Valid Category category) {
        CategoryDTO dto= CategoryDTO.from(category);
        dto= categoryJpaRepository.saveAndFlush(dto);
        Category dtoAsResponse = dto.asResponse();
        return dtoAsResponse;
    }

    @Override
    public List<Category> findAll() {
        return categoryJpaRepository.findAll()
                .stream()
                .map(CategoryDTO::asResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Category findById(Long id) {
        Optional<CategoryDTO> dto = categoryJpaRepository.findById(id);
        return dto.get().asResponse();
    }

    @Override
    public void deleteById(Long id) {
      categoryJpaRepository.deleteById(id);
    }

    @Override
    public Category update(CreateCategory createCategory, Long id) {
        Optional<CategoryDTO> category = categoryJpaRepository.findById(id);
        CategoryDTO dto = category.get();
        dto.setName(createCategory.getName());
        dto.setName_en(createCategory.getName_en());
        dto.setParent(createCategory.getParent());
        dto.setKind(createCategory.getKind());
        dto.setPriority(createCategory.getPriority());
        dto.setImage(createCategory.getImage());
        dto.setVisibility(createCategory.isVisibility());
        dto = categoryJpaRepository.save(dto);
        return dto.asCategory();
    }

    @Override
    public Category patch(Long id, UpdateCategory category) throws InvocationTargetException, IllegalAccessException {
        CategoryDTO toBePatchedCat = objectMapper.convertValue(category,CategoryDTO.class);
        Optional<CategoryDTO> optionalCategory = categoryJpaRepository.findById(id);
        CategoryDTO fromDb = optionalCategory.get();

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> changes = mapper.convertValue(toBePatchedCat, new TypeReference<>() {
            });


            changes.forEach((k, v) -> {
                Field field = ReflectionUtils.findField(CategoryDTO.class, k);
                if (field != null) {
                    if (v != null) {
                        field.setAccessible(true);
                        ReflectionUtils.setField(field, fromDb, v);
                    }
                }
            });
            categoryJpaRepository.save(fromDb);


        return fromDb.asResponse();
    }


}

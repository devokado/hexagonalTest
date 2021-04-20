package com.hexagonal.hexagonalTest.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexagonal.hexagonalTest.Infrastructure.common.NullAwareBeanUtilsBean;
import com.hexagonal.hexagonalTest.Infrastructure.persistance.CategoryDTO;
import com.hexagonal.hexagonalTest.application.ports.ICategoryJpaRepository;
import com.hexagonal.hexagonalTest.presentation.models.CreateCategory;
import com.hexagonal.hexagonalTest.presentation.models.UpdateCategory;
import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.application.ports.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class CategoryJpaAdapter implements ICategory {
    @Autowired
    private NullAwareBeanUtilsBean beanUtils;

    private final ICategoryJpaRepository ICategoryJpaRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public CategoryJpaAdapter(ICategoryJpaRepository ICategoryJpaRepository) {
        this.ICategoryJpaRepository = ICategoryJpaRepository;
    }


    @Override
    public Category save(@Valid Category category) {
        CategoryDTO dto= CategoryDTO.from(category);
        dto= ICategoryJpaRepository.saveAndFlush(dto);
        Category dtoAsResponse = dto.asResponse();
        return dtoAsResponse;
    }

    @Override
    public List<Category> findAll() {
        return ICategoryJpaRepository.findAll()
                .stream()
                .map(CategoryDTO::asResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Category findById(Long id) {
        Optional<CategoryDTO> dto = ICategoryJpaRepository.findById(id);
        if (!dto.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Unable to find resource");
        }
        return dto.get().asResponse();
    }

    @Override
    public void deleteById(Long id) {
      ICategoryJpaRepository.deleteById(id);
    }

    @Override
    public Category update(CreateCategory createCategory, Long id) {
        Optional<CategoryDTO> category = ICategoryJpaRepository.findById(id);
        if (!category.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Unable to find resource");
        }
        CategoryDTO dto = category.get();
        dto.setName(createCategory.getName());
        dto.setName_en(createCategory.getName_en());
        dto.setParent(createCategory.getParent());
        dto.setKind(createCategory.getKind());
        dto.setPriority(createCategory.getPriority());
        dto.setImage(createCategory.getImage());
        dto.setVisibility(createCategory.isVisibility());
        dto = ICategoryJpaRepository.save(dto);

        return dto.asResponse();
    }

    @Override
    public Category patch(Long id, UpdateCategory category){
        CategoryDTO toBePatchedCat = objectMapper.convertValue(category,CategoryDTO.class);
        Optional<CategoryDTO> optionalCategory = ICategoryJpaRepository.findById(id);
        if (!optionalCategory.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Unable to find resource");
        }
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
            ICategoryJpaRepository.save(fromDb);


        return fromDb.asResponse();
    }


}

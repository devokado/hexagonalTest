package com.hexagonal.hexagonalTest.adapter.jpa;

import com.hexagonal.hexagonalTest.adapter.web.CreateCategory;
import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.CategoryRepository;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class CategoryJpaRepositoryAdapter implements CategoryRepository {
    @Autowired
    private NullAwareBeanUtilsBean beanUtils;

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
                .map(CategoryDTO::asResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findById(Long id) {
        Optional<CategoryDTO> dto = categoryJpaRepository.findById(id);
        return dto.map(CategoryDTO::asResponse);
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
        dto = categoryJpaRepository.save(dto);
        return dto.asCategory();
    }

    @Override
    public Category patch(Long id,Category toBePatchedCat) throws InvocationTargetException, IllegalAccessException {
        Optional<CategoryDTO> optionalCategory = categoryJpaRepository.findById(id);
        if(optionalCategory.isPresent()){
            CategoryDTO fromDb = optionalCategory.get();
            // bean utils will copy non null values from toBePatched to fromDb Category.
            BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
            beanUtils.getInstance().copyProperties(fromDb, toBePatchedCat);
            System.out.println(toBePatchedCat);
            System.out.println(fromDb);
            categoryJpaRepository.save(fromDb);
        }
        return null;
    }


}

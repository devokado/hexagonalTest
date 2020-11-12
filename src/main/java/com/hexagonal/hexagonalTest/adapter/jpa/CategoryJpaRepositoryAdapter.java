package com.hexagonal.hexagonalTest.adapter.jpa;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CategoryJpaRepositoryAdapter implements CategoryJpaRepository {

    private final CategoryJpaRepository categoryJpaRepository;

    public CategoryJpaRepositoryAdapter(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public List<CategoryDTO> findAll() {
        return null;
    }

    @Override
    public List<CategoryDTO> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CategoryDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CategoryDTO> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CategoryDTO categoryDTO) {

    }

    @Override
    public void deleteAll(Iterable<? extends CategoryDTO> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Category save(Category category) {

        return category;
    }

    @Override
    public <S extends CategoryDTO> S save(S s) {
        return null;
    }

    @Override
    public <S extends CategoryDTO> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<CategoryDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends CategoryDTO> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<CategoryDTO> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CategoryDTO getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends CategoryDTO> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CategoryDTO> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CategoryDTO> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CategoryDTO> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CategoryDTO> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CategoryDTO> boolean exists(Example<S> example) {
        return false;
    }
}

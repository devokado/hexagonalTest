package com.hexagonal.hexagonalTest.adapter.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.CategoryRepository;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {
    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Get all categories - GET /api/v1/categories")
    public void getAllCategories() throws Exception {

        CreateCategory newCategory1 = new CreateCategory("name", "name", 1, "ss","2", 1, true);
        CreateCategory newCategory2 = new CreateCategory("family", "family", 1, "ss", "2", 1, true);
        List<CreateCategory> categories = new ArrayList<>();
        categories.add(newCategory1);
        categories.add(newCategory2);

        doReturn(categories).when(categoryRepository).findAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/categories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[0].name", is("name")))
                .andExpect(jsonPath("$[1].name", is("family")));

    }

    @Test
    @DisplayName("Create new category - Post /api/v1/categories/create")
    public void createCategory() throws Exception {
        CreateCategory newCat = new CreateCategory("name_en", "name", 1, "ss","2", 1, true);
        Category mockCat = new Category(1L,new NameEN("name_en"), "name", 1, "ss", "2", 1, true);

        doReturn(mockCat).when(categoryRepository).save(ArgumentMatchers.any());

        mockMvc.perform(post("/api/v1/categories/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(newCat)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name",is("name")));


    }
    @Test
    @DisplayName("Update category - put /api/v1/categories/{categoryId} ")
    public void updateCategory() throws Exception{
        CreateCategory newCat = new CreateCategory("shampoo", "shampoo", 1, "new.img","2", 1, true);
        Category mockCat = new Category(1L,new NameEN("shampoo new"), "shampoo new", 1, "img new", "2", 1, true);
        doReturn(mockCat).when(categoryRepository).update(ArgumentMatchers.any(), eq(mockCat.getId()));
        mockMvc.perform(put("/api/v1/categories/{categoryId}",mockCat.getId())
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(new ObjectMapper().writeValueAsString(newCat)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name",is("shampoo new")));
    }
    @Test
    @DisplayName("Get category by id- Get /api/v1/categories/{categoryId} ")
    public void getById() throws Exception{
        Category mockCat = new Category(1L,new NameEN("shampoo new"), "shampoo new", 1, "img new", "2", 1, true);
        doReturn(mockCat).when(categoryRepository).findById(mockCat.getId());
        mockMvc.perform(get("/api/v1/categories/{categoryId}",mockCat.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name",is("shampoo new")));
    }


    @Test
    @DisplayName("delete category by id- delete /api/v1/categories/{categoryId} ")
    public void deleteById() throws Exception {
        Category mockCat = new Category(1L, new NameEN("shampoo new"), "shampoo new", 1, "img new", "2", 1, true);
        doNothing().when(categoryRepository).deleteById(mockCat.getId());
        mockMvc.perform(delete("/api/v1/categories/{categoryId}", mockCat.getId()))
                .andExpect(status().isNoContent());
    }






}
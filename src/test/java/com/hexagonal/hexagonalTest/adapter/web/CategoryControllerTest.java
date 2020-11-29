package com.hexagonal.hexagonalTest.adapter.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.CategoryRepository;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
   public void createCategory() throws Exception {


        mockMvc.perform(post("/category/create")
                .param("name_en","test")
                .param("name","تست")
                .param("parent","1")
                .param("image","sss")
                .param("kind","1")
                .param("priority","1")
                .param("visibility", "true"))
                .andExpect(status().isCreated());



    }
}
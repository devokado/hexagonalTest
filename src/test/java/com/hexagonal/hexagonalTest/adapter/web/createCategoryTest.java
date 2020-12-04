package com.hexagonal.hexagonalTest.adapter.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.Name;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class createCategoryTest {



    @Test
    public void convertsToCategoryDomain() throws Exception{
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        CreateCategory createCategory = new CreateCategory("phone","phone",4,"sss", "2",1,true);
        Category expectedCategory = new Category(new NameEN("phone"),new Name("phone"),4,"sss","2",1,true);
        assertThat(createCategory.asCategory())
                .isEqualToIgnoringGivenFields(expectedCategory, "id");
    }



}

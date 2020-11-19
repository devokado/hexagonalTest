package com.hexagonal.hexagonalTest.adapter.web;

import com.hexagonal.hexagonalTest.domain.catalouge.Category;
import com.hexagonal.hexagonalTest.domain.catalouge.NameEN;
import org.junit.jupiter.api.Test;


import java.sql.Timestamp;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class createCategoryTest {
    @Test
    public void convertsToCategoryDomain() throws Exception{
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        CreateCategory createCategory = new CreateCategory("phone","phone",4,"sss", (char) 2,1,true);
        Category expectedCategory = new Category("phone","phone",4,"sss",(char)2,1,true,false,ts,ts);
        assertThat(createCategory.asCategory())
                .isEqualToIgnoringGivenFields(expectedCategory, "id");
    }

    @Test
    void nameShouldBeMoreThan4letters() throws Exception {
        assertThatThrownBy(()->{new NameEN("xyz"); })
                .isInstanceOf(IllegalArgumentException.class);

    }
}

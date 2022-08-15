package com.project.mall;

import com.project.mall.dao.CategoryMapper;
import com.project.mall.entity.Category;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void contextLoads() {
        //连接查询
        List<Category> categories = categoryMapper.selectAllCategories2(1);
        for (Category c1 : categories){
            System.out.println(c1);
            for (Category c2 : c1.getCategories()){
                System.out.println("\t"+c2);
                for (Category c3 : c2.getCategories()){
                    System.out.println("\t\t" + c3);
                }
            }
        }
    }

}

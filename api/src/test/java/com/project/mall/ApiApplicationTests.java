package com.project.mall;

import com.project.mall.dao.CategoryMapper;
import com.project.mall.dao.ProductMapper;
import com.project.mall.entity.Category;
import com.project.mall.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;
    @Resource
    private ProductMapper productMapper;

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

    @Test
    public void testRecommand(){
        List<Product> products = productMapper.selectRecommendProducts();
        for (Product p : products){
            System.out.println(p);
        }
    }
}

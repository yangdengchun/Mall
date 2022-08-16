package com.project.mall.dao;

import com.project.mall.entity.Product;
import com.project.mall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductMapper extends GeneralDao<Product> {

    public List<Product> selectRecommendProducts();

}
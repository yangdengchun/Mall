package com.project.mall.dao;

import com.project.mall.entity.Product;
import com.project.mall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductMapper extends GeneralDao<Product> {

    public List<Product> selectRecommendProducts();
    /**
     * 查询指定以及类别下销量最高的8个商品
     * @param cid
     * @return
     */
    public List<Product> selectTop8ByCategory(int cid);
}
package com.project.mall.dao;

import com.project.mall.entity.Product;
import com.project.mall.entity.ProductImg;
import com.project.mall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductImgMapper extends GeneralDao<ProductImg> {

    /**根据商品id查询当前商品的图片信息
     *
     */
    public List<ProductImg> selectProductImgByProductId(int productId);

}
package com.project.mall.service;

import com.project.mall.entity.Product;
import com.project.mall.vo.ResultVo;

import javax.annotation.Resource;

/**
 * @author ydc
 * @create 2022-08-16 16:23
 */
public interface ProductService {

    public ResultVo listRecommendProducts();

    public ResultVo getProductBasicInfo(Integer productId);
}

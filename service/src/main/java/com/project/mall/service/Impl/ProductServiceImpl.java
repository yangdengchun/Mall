package com.project.mall.service.Impl;

import com.project.mall.dao.ProductMapper;
import com.project.mall.entity.Product;
import com.project.mall.service.ProductService;
import com.project.mall.vo.ResultStatus;
import com.project.mall.vo.ResultVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ydc
 * @create 2022-08-16 16:23
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public ResultVo listRecommendProducts() {
        List<Product> products = productMapper.selectRecommendProducts();
        ResultVo resultVo = new ResultVo(ResultStatus.OK, "sucess", products);

        return resultVo;
    }
}

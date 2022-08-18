package com.project.mall.service.Impl;

import com.project.mall.dao.ProductImgMapper;
import com.project.mall.dao.ProductMapper;
import com.project.mall.dao.ProductSkuMapper;
import com.project.mall.entity.Product;
import com.project.mall.entity.ProductImg;
import com.project.mall.entity.ProductSku;
import com.project.mall.service.ProductService;
import com.project.mall.vo.ResultStatus;
import com.project.mall.vo.ResultVo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author ydc
 * @create 2022-08-16 16:23
 */
@Service
public class ProductServiceImpl implements ProductService {


    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductImgMapper productImgMapper;
    @Resource
    private ProductSkuMapper productSkuMapper;

    @Override
    public ResultVo listRecommendProducts() {
        List<Product> products = productMapper.selectRecommendProducts();
        ResultVo resultVo = new ResultVo(ResultStatus.OK, "sucess", products);

        return resultVo;
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ResultVo getProductBasicInfo(Integer productId) {
        //tkMapper查询
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        criteria.andEqualTo("productStatus",1);

        List<Product> products = productMapper.selectByExample(example);
        if (products.size() > 0){
            //商品图片
            Example example1 = new Example(ProductImg.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("itemId",productId);
            List<ProductImg> productImgs = productImgMapper.selectByExample(example1);
            //商品规格
            Example example2 = new Example(ProductSku.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("productId",productId);
            criteria2.andEqualTo("status",1);
            List<ProductSku> productSkus = productSkuMapper.selectByExample(example2);

            HashMap<String,Object> basicInfo = new HashMap<>();
            basicInfo.put("product",products.get(0));
            basicInfo.put("productImgs",productImgs);
            basicInfo.put("productSkus",productSkus);
            return new ResultVo(ResultStatus.OK,"success",basicInfo);
        } else {
            return new ResultVo(ResultStatus.NO,"查询商品不存在",null);
        }
    }
}

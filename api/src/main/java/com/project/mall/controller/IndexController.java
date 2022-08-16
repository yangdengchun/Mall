package com.project.mall.controller;
import com.project.mall.service.CategoryService;
import com.project.mall.service.IndexImgService;
import com.project.mall.service.ProductService;
import com.project.mall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author ydc
 * @create 2022-08-10 17:50
 */
@RestController
@CrossOrigin
@RequestMapping("/index")
@Api(tags = "首页管理",value = "首页数据")
public class IndexController {


    @Resource
    private IndexImgService indexImgService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/indeximg")
    @ApiOperation("首页轮播图接口")
    public ResultVo listIndexImgs() {
        return indexImgService.listIndexImgs();
    }


    @GetMapping("/category-list")
    @ApiOperation("商品分类查询接⼝")
    public ResultVo listCatetory() {
        return categoryService.listCategories();
    }

    @GetMapping("/list-recommends")
    @ApiOperation("查询推荐商品的接口")
    public ResultVo listRecommendProducts(){
        return productService.listRecommendProducts();
    }
}

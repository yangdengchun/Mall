package com.project.mall.controller;

import com.project.mall.service.ProductService;
import com.project.mall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ydc
 * @create 2022-08-18 22:18
 */
@RestController
@CrossOrigin
@RequestMapping("/product")
@Api(value = "提供商品详情信息接口",tags = "商品管理")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/detail/{pid}")
    @ApiOperation("商品详情接口")
    public ResultVo getProductBasicInfo(@PathVariable("pid") Integer pid){
        return productService.getProductBasicInfo(pid);
    }

}

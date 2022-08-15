package com.project.mall.controller;

import com.project.mall.vo.ResultStatus;
import com.project.mall.vo.ResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ydc
 * @create 2022-08-06 21:32
 */
@RestController
@RequestMapping("/shopcart")

@Api(tags = "购物车管理",value = "提供购物车业务相关接口")
public class ShopcartController {

    @ApiOperation("购物车列表接口")
    @GetMapping("/list")
    @ApiImplicitParam(dataType = "string",value = "授权令牌",name = "token",required = true,dataTypeClass = Long.class)
    public ResultVo listCarts(String token){
        return new ResultVo(ResultStatus.OK,"success",null);
    }
}

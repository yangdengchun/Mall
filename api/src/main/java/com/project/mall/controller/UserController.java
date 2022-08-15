package com.project.mall.controller;

import com.project.mall.service.UserService;
import com.project.mall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ydc
 * @create 2022-07-29 4:18
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理",value = "提供用户的登录和注册接口")
public class UserController {

    @Resource
    private UserService userService;


    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户登录账号",dataTypeClass = Long.class,required = true),
            @ApiImplicitParam(dataType = "string",name = "password", value = "用户登录密码",dataTypeClass = Long.class,required = true)
    })
    @PostMapping("/login")
    public ResultVo login(@RequestParam(value = "username") String name,
                          @RequestParam(value = "password") String pwd){
        ResultVo resultVO = userService.checkLogin(name, pwd);
        return resultVO;
    }
    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name =
                    "username", value = "用户注册账号",dataTypeClass = Long.class,required = true),
            @ApiImplicitParam(dataType = "string",name =
                    "password", value = "用户注册密码",dataTypeClass = Long.class,required = true)
    })
    @PostMapping("/regist")
    public ResultVo regist(String username,String password){
        ResultVo resultVo = userService.userRegister(username, password);
        return resultVo;
    }
}

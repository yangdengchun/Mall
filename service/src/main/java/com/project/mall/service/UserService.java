package com.project.mall.service;

import com.project.mall.vo.ResultVo;

/**
 * @author ydc
 * @create 2022-07-29 3:59
 */
public interface UserService {
    public ResultVo checkLogin(String name, String pwd);
    public ResultVo userRegister(String name, String pwd);

}

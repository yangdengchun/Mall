package com.project.mall.service;
import com.project.mall.vo.ResultVo;
/**
 * @author ydc
 * @create 2022-08-13 10:38
 */
public interface CategoryService {
    public ResultVo listCategories();

    public ResultVo listCategories2(int i);
}

package com.project.mall.service.Impl;

import com.project.mall.dao.CategoryMapper;
import com.project.mall.entity.Category;
import com.project.mall.service.CategoryService;
import com.project.mall.vo.ResultStatus;
import com.project.mall.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ydc
 * @create 2022-08-13 10:39
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    public ResultVo listCategories() {
        List<Category> category = categoryMapper.selectAllCategories();
        ResultVo resultVo = new ResultVo(ResultStatus.OK, "success", category);
        return resultVo;
    }

    @Override
    public ResultVo listCategories2(int i) {
        List<Category> category = categoryMapper.selectAllCategories2(i);
        ResultVo resultVo = new ResultVo(ResultStatus.OK, "success", category);
        return resultVo;
    }

    @Override
    /**
     * 查询一级分类，同时查询一级分类下销量最高的8个商品
     */
    public ResultVo listFirseLevelCategories() {
        List<Category> categories = categoryMapper.selectFirstLevelCategories();
        return new ResultVo(ResultStatus.OK,"success",categories);
    }
}

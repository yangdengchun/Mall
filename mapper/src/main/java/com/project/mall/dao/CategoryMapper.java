package com.project.mall.dao;

import com.project.mall.entity.Category;
import com.project.mall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends GeneralDao<Category> {

    //连接查询
    public List<Category> selectAllCategories();
    //子查询  根据parentid查询子分类
    public List<Category> selectAllCategories2(int parentId);

    //查询一级类别
    public List<Category> selectFirstLevelCategories();
}
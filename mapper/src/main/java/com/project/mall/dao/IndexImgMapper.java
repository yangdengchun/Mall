package com.project.mall.dao;

import com.project.mall.entity.IndexImg;
import com.project.mall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IndexImgMapper extends GeneralDao<IndexImg> {

    //查询轮播图信息，查询status=1，且按照seq进行排序
    public List<IndexImg> listIndexImgs();

}
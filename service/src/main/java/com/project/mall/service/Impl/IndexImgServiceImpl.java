package com.project.mall.service.Impl;

import com.project.mall.dao.IndexImgMapper;
import com.project.mall.entity.IndexImg;
import com.project.mall.service.IndexImgService;
import com.project.mall.vo.ResultStatus;
import com.project.mall.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ydc
 * @create 2022-08-10 17:43
 */
@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;
    @Override
    public ResultVo listIndexImgs() {
        List<IndexImg> indexImgs = indexImgMapper.listIndexImgs();
        if (indexImgs.size() == 0){
            return new ResultVo(ResultStatus.NO,"fail",null);
        }else {
            return new ResultVo(ResultStatus.OK,"success",indexImgs);
        }
    }
}

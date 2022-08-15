package com.project.mall.general;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author ydc
 * @create 2022-07-31 17:58
 */
public interface GeneralDao<T> extends Mapper<T>, MySqlMapper<T> {
}

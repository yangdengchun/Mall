package com.project.mall.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author ydc
 * @create 2022-08-06 14:05
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ResultStatus {
    OK(100),
    NO(200);

    private Integer code;


    public Integer getCode() {
        return code;
    }
}

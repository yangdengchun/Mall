package com.project.mall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ydc
 * @create 2022-07-29 4:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ResultVO对象",description = "封装接口返回给前端的数据")
public class ResultVo {

    @ApiModelProperty(value = "响应状态码",dataType = "int")
    private  ResultStatus code;
    @ApiModelProperty(value = "响应信息")
    private String msg;
    @ApiModelProperty(value = "响应数据")
    private Object data;
}

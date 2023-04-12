package com.chengming.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "user request" , description = "用户请求实体")
public class UserRequest {

    @ApiModelProperty(value = "用户id", required = true, example = "2023")
    private Integer id;
}

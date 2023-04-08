package com.chengming.reponse;

import lombok.Data;

/**
 * @Name: Response
 * @Author: kitchening
 * @Date: 2023-04-06 22:23
 * @Description: Response
 * @Version: V1.0
 */
@Data
public class Response<T> {

    private int code;

    private String msg;

    private T data;
}

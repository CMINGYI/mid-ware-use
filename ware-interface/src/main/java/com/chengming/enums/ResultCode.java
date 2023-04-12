package com.chengming.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    SUCCESS(200,"成功"),

    FAIL(500, "失败"),

    VALIDATED_FAIL(300,"参数校验失败");

    private final Integer code;

    private final String message;

}

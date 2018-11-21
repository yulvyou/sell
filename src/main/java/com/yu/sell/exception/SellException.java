package com.yu.sell.exception;

import com.yu.sell.enums.ResultEnum;
import lombok.Getter;

/**
 *
 */
@Getter
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
}

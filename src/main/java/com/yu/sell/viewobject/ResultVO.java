package com.yu.sell.viewobject;

import lombok.Data;

/**
 * VO=ViewObject 返回给View的对象
 * http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //返回的具体内容
    private T data;
}

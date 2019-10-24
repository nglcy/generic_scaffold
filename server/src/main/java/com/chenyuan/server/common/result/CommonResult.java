package com.chenyuan.server.common.result;

import lombok.Data;

/**
 * @ClassName CommonResult
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/23 0:02
 */
@Data
public class CommonResult<T> {

    private Integer code;
    private String desc;
    private T data;
}

package com.chenyuan.server.common.exception;

import com.chenyuan.server.common.result.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GloabException
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/9/25 23:38
 */
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    @ResponseBody
    public CommonResult exceptionHandler2(HttpServletRequest request, Exception e) {
        CommonResult result = new CommonResult();
        result.setDesc("系统繁忙，请稍后重试...");
        result.setCode(433);
        return result;
    }
}

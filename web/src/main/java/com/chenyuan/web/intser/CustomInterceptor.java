package com.chenyuan.web.intser;

import org.assertj.core.util.Maps;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CousterIn
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/11/6 21:51
 */

@ControllerAdvice
public class CustomInterceptor implements  HandlerInterceptor {
   private static  final  ThreadLocal USER_LOCAL = new ThreadLocal<String>();

    private static final Set<String> SET = new HashSet<>();

    static {
        SET.add("hello");
        SET.add("/hello/studentAll");
        SET.add("/findStudent/*");
//        SET.add("/index");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        boolean contains = SET.contains(uri);
        if (contains) {
            return true;
        }

        System.out.println("-------------------------------");
        return true;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("---------------");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("------------------");
        USER_LOCAL.remove();
    }
}

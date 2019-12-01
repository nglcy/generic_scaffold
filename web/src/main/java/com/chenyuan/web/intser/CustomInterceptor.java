package com.chenyuan.web.intser;

import org.assertj.core.util.Maps;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
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
        SET.add("hello/studentAll");
        SET.add("findStudent/*");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (SET.contains(uri)) {
            return true;
        }
        //登录权限拦截
        System.out.println("preHandle");
        boolean b1 = request.getRequestURI().endsWith("/tologin");
        boolean b2 = request.getRequestURI().endsWith("/login");

        if(b1){
            //tologin放行
            return true;
        }else if(b2){
            //login放行
            return true;
        }else{
            //访问其他控制器，首先判断用户是否登录，登录则放行，否则跳转tologin
            response.sendRedirect("tologin");
            return false;
        }


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

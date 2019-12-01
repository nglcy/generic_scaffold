package com.chenyuan.web.intser;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName Fileters
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/11/6 22:22
 */
public class Fileters implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("111111111111111111");
    }

    @Override
    public void destroy() {
        System.out.println("0000000000000000000000000");
    }
}

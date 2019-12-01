package com.chenyuan.server.config;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @ClassName IntercepterConfig
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/11/9 12:35
 */
public class IntercepterConfig extends WebMvcAutoConfiguration {

    /*@Bean
    public HandlerInterceptor getCustomInterceptor(){
//        return new CustomInterceptor()

    }*/
    @Override
    public OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return super.hiddenHttpMethodFilter();
    }

    @Override
    public OrderedFormContentFilter formContentFilter() {
        return super.formContentFilter();
    }
}

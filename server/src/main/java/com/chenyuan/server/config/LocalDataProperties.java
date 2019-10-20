package com.chenyuan.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName LocalDatePropertiy
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/20 23:07
 */
@Component
@Data
@ConfigurationProperties("spring.datasource.local")
public class LocalDataProperties {

    private  String username;
    private String password;
    private String url;
    private String driverClassName;
}

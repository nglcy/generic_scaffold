package com.chenyuan.web;

import com.chenyuan.dao.mapper.local.LocalStudentMapper;
import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.LocalStudentService;
import com.chenyuan.server.RedisService;
import com.chenyuan.server.StudentService;
import com.chenyuan.server.common.RedisConfig;
import com.chenyuan.server.config.LocalDataProperties;
import com.chenyuan.server.config.LocalDataSourcesConfig;
import com.chenyuan.server.impl.LocalStudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LocalDataSourcesConfig.class, MybatisAutoConfiguration.class, LocalStudentServiceImpl.class, LocalDataProperties.class})
/**
 *  这里指定的classes是可选的。如果不指定classes，则spring boot会启动整个spring容器，很慢（比如说会执行一些初始化，ApplicationRunner、CommandLineRunner等等）。不推荐
 *  指定的话，就只会初始化指定的bean，速度快，推荐
 */
@Slf4j
@TestPropertySource("classpath:application-mapper.properties")
/**
 比如一个项目多人撰写，A同学要进行服务层的单元测试（需要一堆配置），B同学要进行数据库层面的单元测试（只需要本案例的配置），而且大家的配置可能还不一样？这时有没有B同学可以指定我不读test/recources/application.properties文件的办法（这个让给A），而是指定去读test/recources/mapper-application.properties的办法 **/
public class WebApplicationTests {
//    @Autowired
//    private StudentService studentService;

    @Autowired
    private LocalStudentService localStudentService;

    @Test
    public void getStudent(){
        localStudentService.findList().stream().forEach(System.out::println);
    }

    @Test
    public void contextLoads(){
        System.out.println("---------------");
//        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> localStudentService.insert(new Student(29, "hello", "java", 1, 2.0)));
        System.out.println("0000000000000000000000000000000");


//        int i = studentService.saveStudentToMultiDataSources(new Student(27, "尘缘", "杭州", 23, 2.0), true
//        );
//        log.info(i + "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//        Assert.assertEquals(1, i);
    }


//    @Autowired
//    private RedisManager redisManager;
//
//    @Test
//    public void test() {
//        redisManager.set("helloworlds", "helloworlds");
//        String s = redisManager.get("helloworlds");
//        System.out.println(s);
//    }

//    @Autowired
    private RedisService redisService;

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void testRedis() {
        String key = "hello3";
        redisService.set(key, "BBB");
        String aaa = (String) redisService.get(key);
        Assert.assertEquals("BBB", aaa);
//        log.info(aaa.toString());
//        redisTemplate
    }



}

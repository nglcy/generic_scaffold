package com.chenyuan.web;

import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.LocalStudentService;
import com.chenyuan.server.RedisService;
import com.chenyuan.server.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WebApplicationTests {
    @Autowired
    private StudentService studentService;

    @Autowired
    private LocalStudentService localStudentService;

    @Test
    public void contextLoads(){
        System.out.println("---------------");
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> localStudentService.insert(new Student(29, "hello", "java", 1, 2)));
        System.out.println("0000000000000000000000000000000");


        int i = studentService.saveStudentToMultiDataSources(new Student(27, "尘缘", "杭州", 23, 2), true
        );
        log.info(i + "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        Assert.assertEquals(1, i);
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

    @Autowired
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

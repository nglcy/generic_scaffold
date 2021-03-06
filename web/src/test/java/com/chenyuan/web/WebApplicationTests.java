package com.chenyuan.web;

import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WebApplicationTests {
    @Autowired
    private StudentService studentService;

    @Test
    public void contextLoads() {

        int i = studentService.saveStudentToMultiDataSources(new Student(27, "尘缘", "杭州", 23, 2), false
        );
        log.info(i+"");
        Assert.assertEquals(1,i);
    }

}

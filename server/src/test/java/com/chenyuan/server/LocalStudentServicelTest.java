package com.chenyuan.server;

import com.chenyuan.dao.mapper.local.LocalStudentMapper;
import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.impl.LocalStudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName StudentServicelTest
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/21 21:12
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LocalStudentService.class})
@Slf4j
@ContextConfiguration(
        {
                "classpath:mapper/local/LocalStudentMapper.xml"
        }
)
public class LocalStudentServicelTest {

    @Autowired
    private LocalStudentService localStudentService;
    @Test
    public void findStudentByIdTest(){
        localStudentService.findStudent(1);
    }
}

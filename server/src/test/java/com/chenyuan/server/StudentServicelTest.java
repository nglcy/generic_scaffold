package com.chenyuan.server;

import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.common.result.StudentVO;
import com.chenyuan.server.impl.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName StudentServicelTest
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/21 21:12
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudentServiceImpl.class})
@Slf4j

public class StudentServicelTest {

    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private LocalStudentService localStudentService;
    @Test
    public void saveStudentToMultiDataSources(){

        int i = studentService.saveStudentToMultiDataSources(new Student(6, "尘缘", "杭州", 23, 2), true
        );
        log.info(i+"");
        Assert.assertEquals(1,i);
    }
//
//    @Test
//    public void  findStudentByIdTest(){
//        StudentVO studentById = localStudentService.findStudentById(1);
//        System.out.println(studentById.toString());
//    }
}


package com.chenyuan.server;

import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.common.result.StudentVO;

import java.util.List;

/**
 * @ClassName StudentService
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/13 23:30
 */

public interface LocalStudentService {
    List<Student> findList();

    StudentVO findStudentById(Integer id);
    int insert(Student student);
}

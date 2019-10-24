package com.chenyuan.server;

import com.chenyuan.entity.DO.Student;

import java.util.List;

/**
 * @ClassName StudentService
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/13 23:30
 */

public interface LocalStudentService {


    public List<Student> findList();

    Student findStudent(int i);
}

package com.chenyuan.server.impl;

import com.chenyuan.dao.mapper.local.LocalStudentMapper;
import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.LocalStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/13 23:43
 */
@Service
public class LocalStudentServiceImpl implements LocalStudentService {

    @Autowired
    private LocalStudentMapper localStudentMapper;

    @Override
    public List<Student> findList() {
        return localStudentMapper.selectAll();
    }

    @Override
    public Student findStudent(int id) {
        return localStudentMapper.selectByPrimaryKey(id);
    }
}

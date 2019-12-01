package com.chenyuan.server.impl;

import com.chenyuan.dao.mapper.local.LocalStudentMapper;
import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.LocalStudentService;
import com.chenyuan.server.common.result.StudentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public StudentVO findStudentById(Integer id) {
        Student student = localStudentMapper.selectByPrimaryKey(id);
        StudentVO studentVO = new StudentVO();
        BeanUtils.copyProperties(student,studentVO);
        return  studentVO;

    }

    @Override
    public int insert(Student student) {
        try {
            TimeUnit.MILLISECONDS.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return localStudentMapper.insert(student);
    }
}

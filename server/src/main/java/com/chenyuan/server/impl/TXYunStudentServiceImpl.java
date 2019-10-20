package com.chenyuan.server.impl;

import com.chenyuan.dao.mapper.txyun.TXYunStudentMapper;
import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.TXYunStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName TXYunStudentServiceImpl
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/20 18:27
 */
@Service
public class TXYunStudentServiceImpl implements TXYunStudentService {

    @Autowired
    private TXYunStudentMapper txYunStudentMapper;

    @Override
    public int save(Student student) {
        return txYunStudentMapper.insert(student);
    }
}

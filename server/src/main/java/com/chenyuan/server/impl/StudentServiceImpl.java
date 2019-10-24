package com.chenyuan.server.impl;

import com.chenyuan.dao.mapper.local.LocalStudentMapper;
import com.chenyuan.dao.mapper.txyun.TXYunStudentMapper;
import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;

/**
 * @ClassName StudentServiceImpl
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/21 21:02
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private TXYunStudentMapper txYunStudentMapper;
    @Autowired
    private LocalStudentMapper localStudentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "localTransactionManager")
    public int saveStudentToMultiDataSources(Student student, boolean exceptionFlag) {
        int localInsertCount = localStudentMapper.insert(student);
        if (!exceptionFlag) {
            throw  new RuntimeException("本地保存失败，请重试...");
        }
        int txYunInsertCount = txYunStudentMapper.insert(student);
        return (localInsertCount > 0 && txYunInsertCount >0) ? 1: 0 ;
    }
}

package com.chenyuan.dao.mapper.local;

import com.chenyuan.entity.DO.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAll();
}
package com.chenyuan.server;

import com.chenyuan.entity.DO.Student;

/**
 * @ClassName StudentService
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/21 21:00
 */
public interface StudentService {

    /**
     * @Author chenyuan
     * @Description // 多数据源保存
     * @Date 21:03 2019/10/21
     * @Param [student, execeptionFlag]
     * @return int
     **/
    int saveStudentToMultiDataSources(Student student, boolean exceptionFlag);
}

package com.chenyuan.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.LocalStudentService;
import com.chenyuan.server.StudentService;
import com.chenyuan.server.TXYunStudentService;
import com.chenyuan.server.common.result.StudentVO;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName StudentController
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/13 23:24
 */
@RestController
public class StudentController {
    @Autowired
    private TXYunStudentService txYunStudentService;

    @Autowired
    private LocalStudentService localStudentService;

    @GetMapping("findList")
    public String findList(){
       List<Student> list =  localStudentService.findList();
        StringBuilder builder = new StringBuilder();
        Consumer<Student> studentConsumer = student -> {
            builder.append(JSONObject.toJSONString(student));

        }; list.forEach(studentConsumer);

       return  builder.toString();
    }
    @GetMapping("findListAll")
    public List<Student> findListAll(){
        return localStudentService.findList();
    }

    @GetMapping("findStudent/{id}")
    public StudentVO findStudentById(@PathVariable("id")Integer id){
        return localStudentService.findStudentById(id);
    }

//    @GetMapping("txyun")
    @PostMapping("txyun")
    public int save(@RequestBody Student student){
//        Student student = new Student(6, "尘缘", "杭州", 23, 2);
        return txYunStudentService.save(student);
    }
    @PostMapping("/saveOne")
    public String saveOneStudent(@RequestBody Student student){
        Double dou = student.getDou();
        if (dou != null) {
            student.setNum(dou*100);
        }
        int insert = localStudentService.insert(student);
        return insert>0 ?"success":"fail";
    }



}


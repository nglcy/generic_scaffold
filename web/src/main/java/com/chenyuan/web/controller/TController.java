package com.chenyuan.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.chenyuan.entity.DO.Student;
import com.chenyuan.server.LocalStudentService;
import com.chenyuan.server.TXYunStudentService;
import com.chenyuan.server.common.result.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName StudentController
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/13 23:24
 */
@Controller
public class TController {
    @Autowired
    private TXYunStudentService txYunStudentService;

    @Autowired
    private LocalStudentService localStudentService;


    @GetMapping("index")
    public String getss(){
        System.out.println("0000000000000000000000000000000000000000000");
        return "/index.html";
    }


}


package com.chenyuan.entity.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;

    private String stuName;

    private String address;

    private Integer age;

    private Integer num;

}
package com.chenyuan.entity.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Integer id;

    private String stuName;

    private String address;

    private Integer age;

    private Double num;
    private Double dou;




}
package com.chris.bootlaunch.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Min;

@Data
public class Father {

//    @Value("${family.father.name}")
    private String name;

//    @Value("${family.father.age}")
    //值至少要大於參數中設定的值
    @Min(21)
    private Integer age;


}

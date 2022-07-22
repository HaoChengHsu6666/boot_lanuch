package com.chris.bootlaunch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

//jackson的ObjectMapper 轉換物件時需加入下列兩段建構子方法
//全參數建構子方法
@AllArgsConstructor
//無參數建構子方法
@NoArgsConstructor
public class Reader {

    private String name;

    private Integer age;

}

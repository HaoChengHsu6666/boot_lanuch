package com.chris.bootlaunch.model;

import lombok.Data;

@Data
public class Child {
    private String name;
    private Integer age;
    private Friend[] friend;
}

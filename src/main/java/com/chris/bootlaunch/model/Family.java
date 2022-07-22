package com.chris.bootlaunch.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Component
//嵌套的驗證功能，讓旗下的類別標住的驗證條件生效
@Validated
//批量注入屬性值到Java類別中
@ConfigurationProperties(prefix = "family")
public class Family {

//    當下這一個屬性值指定注入到Java類別中
//    @Value("${family.family-name}")

    @NotNull
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;

}

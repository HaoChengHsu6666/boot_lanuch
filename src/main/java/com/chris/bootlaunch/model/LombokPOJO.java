package com.chris.bootlaunch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LombokPOJO {

//    private static final Logger log = LoggerFactory.getLogger(LombokPOJO.class);

    private String name;
    private Integer age;
}

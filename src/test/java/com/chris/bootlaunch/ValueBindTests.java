package com.chris.bootlaunch;//package com.chris.bootlaunch;

import com.chris.bootlaunch.model.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class) //JUnit4開發者使用這個註解
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ValueBindTests {

    @Resource
    Family family;

    @Test
    public void valueBindTests() throws  Exception {
        System.out.println(family.toString());


    }


}

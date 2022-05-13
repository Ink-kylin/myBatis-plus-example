package com.example.mybatis;

import com.example.mybatis.entity.Demo;
import com.example.mybatis.service.IDemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author kylin
 */
@SpringBootTest
public class QueryTest {

    @Autowired
    IDemoService demoService;

    @Test
    void context(){
        List<Demo> list = demoService.lambdaQuery().eq(Demo::getAge, 66)
                .list();
        System.out.println(list);


    }

}

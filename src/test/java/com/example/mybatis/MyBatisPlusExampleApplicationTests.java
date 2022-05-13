package com.example.mybatis;

import com.example.mybatis.entity.Demo;
import com.example.mybatis.mapper.DemoMapper;
import com.example.mybatis.service.IDemoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MyBatisPlusExampleApplicationTests {

    @Autowired
    DemoMapper demoMapper;

    @Autowired
    IDemoService demoService;

    //CRUD

    @Test
    void context(){
        Demo demo = new Demo();
        demo.setName("大林子");
        demo.setBirthDate(LocalDateTime.now());
        demoMapper.insert(demo);
        Assertions.assertNotNull(demo.getId());

    }

    @Test
    void contextLoads() {
        List<Demo> demoList = demoService.lambdaQuery()
                .like(Demo::getName, "林")
                .list();
        System.out.println(demoList);
    }

    @Test
    void  insert(){

    }


}
